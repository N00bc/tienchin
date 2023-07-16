package com.cyn.tienchin.contract.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.business.domain.Business;
import com.cyn.tienchin.business.service.IBusinessService;
import com.cyn.tienchin.common.constant.TienChinConstants;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.utils.SecurityUtils;
import com.cyn.tienchin.contract.domain.Contract;
import com.cyn.tienchin.contract.domain.ContractSummary;
import com.cyn.tienchin.contract.mapper.ContractMapper;
import com.cyn.tienchin.contract.service.IContractService;
import com.cyn.tienchin.course.domain.Course;
import com.cyn.tienchin.course.service.ICourseService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
                .taskAssignee(SecurityUtils.getUsername())
                .taskDefinitionKey("submitContractTask")
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
                ContractSummary contractSummary = new ContractSummary();
                // 根据合同id获取合同
                Contract contract = getById(contractId);
                BeanUtils.copyProperties(contract, contractSummary);
                // 设置任务id 方便进行审批
                contractSummary.setTaskId(taskId);
                return contractSummary;
            }).collect(Collectors.toList());
        }
        return result;
    }
}
