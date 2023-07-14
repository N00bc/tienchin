package com.cyn.tienchin.business.service;

import com.cyn.tienchin.business.domain.Business;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.business.domain.BusinessFollow;
import com.cyn.tienchin.business.domain.BusinessSummary;
import com.cyn.tienchin.business.domain.BusinessVo;
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
     * @param businessVo
     */
    List<BusinessSummary> selectBusinessSummaryList(BusinessVo businessVo);

    /**
     * 添加新商机
     * @param business
     * @return
     */
    AjaxResult addBusiness(Business business);

    /**
     * 根据`businessId`查询`bussinessDetails`
     * @param id
     * @return
     */
    AjaxResult getBusinessById(Integer id);

    /**
     * 保存客户详细信息
     * @param businessFollow
     * @return
     */
    AjaxResult insertBusinessFollow(BusinessFollow businessFollow);

    /**
     * 根据商机id获取`BusinessSummary`
     * @param businessId
     * @return
     */
    AjaxResult getBusinessSummaryById(Integer businessId);

    /**
     * 更新摘要信息
     * @param business
     * @return
     */
    AjaxResult editBusiness(Business business);

    /**
     * 根据id删除商机
     * @param ids
     * @return
     */
    AjaxResult removeBusinessByIds(Long[] ids);
}
