package com.cyn.tienchin.business.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.assign.service.IAssignService;
import com.cyn.tienchin.business.domain.Business;
import com.cyn.tienchin.business.domain.BusinessSummary;
import com.cyn.tienchin.business.mapper.BusinessMapper;
import com.cyn.tienchin.business.service.IBusinessService;
import com.cyn.tienchin.common.constant.TienChinConstants;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.cyn.tienchin.assign.domain.Assign;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-11
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private IAssignService assignService;

    /**
     * 展示商机摘要
     *
     * @return
     */
    @Override
    public List<BusinessSummary> selectBusinessSummaryList() {
        List<BusinessSummary> businessSummaryList = businessMapper.selectBusinessSummaryList();
        return businessSummaryList;
    }

    /**
     * 添加新商机
     *
     * @param business
     * @return
     */
    @Override
    public AjaxResult addBusiness(Business business) {
        /*
        1.通过手机号查找商机
         */
        Business one = getOne(Wrappers.<Business>lambdaQuery().eq(Business::getPhoneNumber, business.getPhoneNumber()));
        if (one != null) {
            return AjaxResult.error("当前客户信息已存在");
        }
        business.setStatus(TienChinConstants.BUSINESS_ALLOCATE);
        save(business);
        Assign assign = getAssignByBusiness(business);
        assignService.save(assign);
        return AjaxResult.success("添加商机成功");
    }

    /**
     * 根据商机获取
     *
     * @param business
     * @return
     */
    private Assign getAssignByBusiness(Business business) {
        Assign assign = new Assign();
        assign.setAssignId(business.getBusinessId());
        assign.setType(TienChinConstants.BUSINESS_TYPE);
        assign.setLatest(TienChinConstants.IS_LATEST);
        assign.setDeptId(SecurityUtils.getDeptId());
        assign.setUserId(SecurityUtils.getUserId());
        assign.setUserName(SecurityUtils.getUsername());
        return assign;
    }
}
