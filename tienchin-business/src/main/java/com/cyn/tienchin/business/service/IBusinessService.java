package com.cyn.tienchin.business.service;

import com.cyn.tienchin.business.domain.Business;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.business.domain.BusinessSummary;
import com.cyn.tienchin.common.core.domain.AjaxResult;

import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyn
 * @since 2023-07-11
 */
public interface IBusinessService extends IService<Business> {
    /**
     * 展示商机摘要
     *
     * @return
     */
    List<BusinessSummary> selectBusinessSummaryList();

    /**
     * 添加新商机
     * @param business
     * @return
     */
    AjaxResult addBusiness(Business business);
}
