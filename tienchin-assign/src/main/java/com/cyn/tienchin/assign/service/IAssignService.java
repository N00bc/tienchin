package com.cyn.tienchin.assign.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.assign.domain.Assign;
import com.cyn.tienchin.common.core.domain.AjaxResult;

/**
 * <p>
 * 线索 商机明细表 服务类
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
public interface IAssignService extends IService<Assign> {

    /**
     * 增加分派记录
     * @param assign
     * @return
     */
    AjaxResult addAssign(Assign assign);
}
