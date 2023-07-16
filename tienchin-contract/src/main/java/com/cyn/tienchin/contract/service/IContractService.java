package com.cyn.tienchin.contract.service;

import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.contract.domain.Contract;
import com.baomidou.mybatisplus.extension.service.IService;
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

}
