package com.cyn.tienchin.contract.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.business.domain.Business;
import com.cyn.tienchin.business.service.IBusinessService;
import com.cyn.tienchin.common.constant.TienChinConstants;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.utils.SecurityUtils;
import com.cyn.tienchin.common.utils.sign.Base64;
import com.cyn.tienchin.contract.domain.Contract;
import com.cyn.tienchin.contract.domain.ContractApproveInfo;
import com.cyn.tienchin.contract.domain.ContractSummary;
import com.cyn.tienchin.contract.mapper.ContractMapper;
import com.cyn.tienchin.contract.service.IContractService;
import com.cyn.tienchin.course.domain.Course;
import com.cyn.tienchin.course.service.ICourseService;
import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 合同实体 服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-15
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {
    @Autowired
    private IBusinessService businessService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * 新增合同
     *
     * @param contract
     * @return
     */
    @Override
    public AjaxResult addContract(Contract contract) {
        // 1.向`tienchin_contract`中添加数据
        // 1.1查询商机ID并设置
        LambdaQueryWrapper<Business> businessQuery = Wrappers.<Business>lambdaQuery()
                .eq(Business::getPhoneNumber, contract.getPhoneNumber())
                .orderByDesc(Business::getCreateTime);
        List<Business> businessList = businessService.list(businessQuery);
        if (!businessList.isEmpty()) {
            contract.setBusinessId(businessList.get(0).getBusinessId());
        }
        // 1.2查询课程价格并设置
        LambdaQueryWrapper<Course> courseQuery = Wrappers.<Course>lambdaQuery()
                .eq(Course::getCourseId, contract.getCourseId());
        Course course = courseService.getOne(courseQuery);
        if (course != null) {
            contract.setCoursePrice(course.getPrice());
        }
        contract.setStatus(TienChinConstants.WAITING_APPROVE);
        save(contract);
        // 2.启动流程
        Map<String, Object> variables = new HashMap<>();
        variables.put("currentUser", SecurityUtils.getUsername());
        // xml中的processId对应这里的key
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(TienChinConstants.CONTRACT_PROCESS_DEFINITION_ID, variables);
        Map<String, Object> params = new HashMap<>();
        params.put("contractId", contract.getContractId());
        params.put("approveUser", contract.getApproveUserName());
        params.put("approveUserId", contract.getApproveUserId());
        // 2.1启动流程
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();
        taskService.complete(task.getId(), params);
        // 3.更新合同信息
        contract.setProcessInstanceId(processInstance.getProcessInstanceId());
        updateById(contract);
        return AjaxResult.success("添加合同信息成功");
    }

    /**
     * 查询待审批流程
     *
     * @return
     */
    @Override
    public List<ContractSummary> getUnapproveTask() {
        // 查询当前用户需要处理的任务
        List<Task> list = taskService.createTaskQuery()
                // 设置处理人
                .taskAssignee(SecurityUtils.getUsername())
                .active()
                .orderByTaskCreateTime()
                .desc()
                .list();
        // 根据待处理任务获取合同信息
        List<ContractSummary> result = Collections.<ContractSummary>emptyList();
        if (!list.isEmpty()) {
            result = list.stream().map(task -> {
                String taskId = task.getId();
//                Integer contractId = (Integer) task.getProcessVariables().get("contractId");
                Integer contractId = (Integer) taskService.getVariable(taskId, "contractId");
                String reason = (String) taskService.getVariable(taskId, "reason");

                ContractSummary contractSummary = new ContractSummary();
                // 根据合同id获取合同
                Contract contract = getById(contractId);
                BeanUtils.copyProperties(contract, contractSummary);
                // 设置任务id 方便进行审批
                contractSummary.setTaskId(taskId);
                contractSummary.setReason(reason);
                return contractSummary;
            }).collect(Collectors.toList());
        }
        return result;
    }

    /**
     * 根据合同Id查看合同
     *
     * @param id
     * @return
     */
    @Override
    public AjaxResult getContractBytId(Integer id) {
        Contract contract = getById(id);
        if (contract == null) {
            return AjaxResult.error("当前合同不存在");
        }
        return AjaxResult.success(contract);
    }


    /**
     * 将word转为pdf预览
     *
     * @param bytes    二进制数据
     * @param fileName 文件名
     * @return
     */
    @Override
    public AjaxResult transWord2Pdf(byte[] bytes, String fileName) {
        try (InputStream inputStream = new ByteArrayInputStream(bytes);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            IConverter converter = LocalConverter.builder().build();
            converter.convert(inputStream).as(DocumentType.DOCX).to(baos).as(DocumentType.PDF).execute();
            return AjaxResult.success(Base64.encode(baos.toByteArray()));
        } catch (Exception exception) {
            return AjaxResult.error(fileName + ":转换pdf失败");
        }
    }

    /**
     * 查询已提交但待审批任务
     *
     * @return
     */
    @Override
    public List<ContractSummary> getCommittedTask() {
        List<Execution> executionList = runtimeService.createExecutionQuery()
                .variableValueEquals("currentUser", SecurityUtils.getUsername())
                .processDefinitionKey(TienChinConstants.CONTRACT_PROCESS_DEFINITION_ID)
                .list();
        List<ContractSummary> result = Collections.<ContractSummary>emptyList();
        if (!executionList.isEmpty()) {
            result = executionList.stream().map(execution -> {
                String executionId = execution.getId();
                Integer contractId = (Integer) runtimeService.getVariable(executionId, "contractId");
                ContractSummary contractSummary = new ContractSummary();
                Contract contract = getById(contractId);
                BeanUtils.copyProperties(contract, contractSummary);
                contractSummary.setTaskId(executionId);
                return contractSummary;
            }).collect(Collectors.toList());
        }
        return result;
    }

    /**
     * 审批任务
     *
     * @param contractApproveInfo 是否同意
     * @return
     */
    @Override
    public AjaxResult approveOrReject(ContractApproveInfo contractApproveInfo) {
        Map<String, Object> params = new HashMap<>();
        Boolean isApprove = contractApproveInfo.getApprove();
        params.put("approve", isApprove);
        params.put("reason", contractApproveInfo.getReason());
        taskService.complete(contractApproveInfo.getTaskId(), params);
        // 修改合同状态
        LambdaUpdateWrapper<Contract> lambdaUpdateWrapper;
        if (isApprove) {
            lambdaUpdateWrapper = Wrappers.<Contract>lambdaUpdate()
                    .eq(Contract::getContractId, contractApproveInfo.getContractId())
                    .set(Contract::getStatus, TienChinConstants.IS_APPROVE);
        } else {
            lambdaUpdateWrapper = Wrappers.<Contract>lambdaUpdate()
                    .eq(Contract::getContractId, contractApproveInfo.getContractId())
                    .set(Contract::getStatus, TienChinConstants.REJECT);
        }
        update(lambdaUpdateWrapper);
        return AjaxResult.success("审批完成");
    }
}
