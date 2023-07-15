package com.cyn.tienchin.contract.service.impl;

import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.contract.domain.Contract;
import com.cyn.tienchin.contract.mapper.ContractMapper;
import com.cyn.tienchin.contract.service.IContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    /**
     * 新增合同
     *
     * @param contract
     * @return
     */
    @Override
    public AjaxResult addContract(Contract contract) {
        // 1.向`tienchin_contract`中添加数据
        return null;
    }
}
