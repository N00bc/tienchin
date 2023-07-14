package com.cyn.tienchin.business.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.assign.domain.Assign;
import com.cyn.tienchin.assign.service.IAssignService;
import com.cyn.tienchin.business.domain.*;
import com.cyn.tienchin.business.mapper.BusinessMapper;
import com.cyn.tienchin.business.service.IBusinessService;
import com.cyn.tienchin.common.constant.TienChinConstants;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.utils.SecurityUtils;
import com.cyn.tienchin.follow.domain.FollowRecord;
import com.cyn.tienchin.follow.service.IFollowRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    @Autowired
    private IFollowRecordService followRecordService;

    /**
     * 展示商机摘要
     *
     * @return
     * @param businessVo
     */
    @Override
    public List<BusinessSummary> selectBusinessSummaryList(BusinessVo businessVo) {
        List<BusinessSummary> businessSummaryList = businessMapper.selectBusinessSummaryList(businessVo);
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
     * 根据`businessId`查询`bussinessDetails`
     *
     * @param id
     * @return
     */
    @Override
    public AjaxResult getBusinessById(Integer id) {
        Business business = getById(id);
        return AjaxResult.success(business);
    }

    /**
     * 保存客户详细信息
     * 1.更新线索表
     * 2.添加一个跟踪记录
     *
     * @param businessFollow
     * @return
     */
    @Override
    public AjaxResult insertBusinessFollow(BusinessFollow businessFollow) {
        // 1.更新线索表
        Business business = new Business();
        BeanUtils.copyProperties(businessFollow, business);
        updateById(business);
        // 2.添加一条跟踪记录
        FollowRecord followRecord = generateFollowRecordByBusinessFollow(businessFollow);
        followRecordService.save(followRecord);
        return AjaxResult.success("更新成功");
    }

    /**
     * 根据商机id获取`BusinessSummary`
     *
     * @param businessId
     * @return
     */
    @Override
    public AjaxResult getBusinessSummaryById(Integer businessId) {
        Business business = getById(businessId);
        BusinessSummaryVo businessSummaryVo = new BusinessSummaryVo();
        BeanUtils.copyProperties(business, businessSummaryVo);
        return AjaxResult.success(businessSummaryVo);
    }

    /**
     * 更新摘要信息
     *
     * @param business
     * @return
     */
    @Override
    public AjaxResult editBusiness(Business business) {
        updateById(business);
        return AjaxResult.success("更新商机成功");
    }

    /**
     * 根据id删除商机
     *
     * @param ids
     * @return
     */
    @Override
    public AjaxResult removeBusinessByIds(Long[] ids) {
        removeBatchByIds(Arrays.asList(ids));
        return AjaxResult.success("删除商机成功");
    }
    // =========================================== Private Methods ===========================================

    /**
     * 生成`FollowRecord`
     *
     * @param businessFollow
     * @return
     */
    private FollowRecord generateFollowRecordByBusinessFollow(BusinessFollow businessFollow) {
        FollowRecord followRecord = new FollowRecord();
        followRecord.setInfo(businessFollow.getInfo());
        followRecord.setType(TienChinConstants.BUSINESS_TYPE);
        followRecord.setAssignId(businessFollow.getBusinessId());
        return followRecord;
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
