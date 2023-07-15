package com.cyn.tienchin.contract.service;

import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.contract.domain.Contract;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
