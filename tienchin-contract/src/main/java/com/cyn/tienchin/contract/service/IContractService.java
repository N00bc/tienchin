package com.cyn.tienchin.contract.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.contract.domain.Contract;
import com.cyn.tienchin.contract.domain.ContractApproveInfo;
import com.cyn.tienchin.contract.domain.ContractSummary;

import java.util.List;

/**
 * <p>
 * 合同实体 服务类
 * </p>
 *
 * @author cyn
 * @since 2023-07-15
 */
public interface IContractService extends IService<Contract> {

    /**
     * 新增合同
     * @param contract
     * @return
     */
    AjaxResult addContract(Contract contract);

    /**
     * 查询待审批流程
     * @return
     */
    List<ContractSummary> getUnapproveTask();

    /**
     * 根据合同Id查看合同
     * @param id
     * @return
     */
    AjaxResult getContractBytId(Integer id);


    /**
     * 将word转为pdf预览
     * @param bytes 二进制数据
     * @param fileName 文件名
     * @return
     */
    AjaxResult transWord2Pdf(byte[] bytes, String fileName);

    /**
     * 查询已提交但待审批任务
     * @return
     */
    List<ContractSummary> getCommittedTask();

    /**
     * 审批任务
     * @param contractApproveInfo 是否同意
     * @return
     */
    AjaxResult approveOrReject(ContractApproveInfo contractApproveInfo);
}
