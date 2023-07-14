package com.cyn.tienchin.web.controller.tienchin.business;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cyn.tienchin.activity.domain.Activity;
import com.cyn.tienchin.activity.service.IActivityService;
import com.cyn.tienchin.business.domain.Business;
import com.cyn.tienchin.business.domain.BusinessFollow;
import com.cyn.tienchin.business.domain.BusinessSummary;
import com.cyn.tienchin.business.domain.BusinessVo;
import com.cyn.tienchin.business.service.IBusinessService;
import com.cyn.tienchin.channel.service.IChannelService;
import com.cyn.tienchin.common.annotation.Log;
import com.cyn.tienchin.common.core.controller.BaseController;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.core.page.TableDataInfo;
import com.cyn.tienchin.common.enums.BusinessType;
import com.cyn.tienchin.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cyn
 * @since 2023-07-11
 */
@RestController
@RequestMapping("/tienchin/business")
public class BusinessController extends BaseController {
    @Autowired
    private IBusinessService businessService;
    @Autowired
    private IActivityService activityService;
    @Autowired
    private IChannelService channelService;
    @Autowired
    private ICourseService courseService;

    @PreAuthorize("hasPermission('tienchin:business:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessVo businessVo) {
        startPage();
        List<BusinessSummary> list = businessService.selectBusinessSummaryList(businessVo);
        return getDataTable(list);
    }

    /**
     * 添加商机:
     * 意愿及其强烈的客户可以直接新增
     *
     * @param business
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:business:add')")
    @Log(title = "商机管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Business business) {
        return businessService.addBusiness(business);
    }

    @PreAuthorize("hasPermission('tienchin:business:edit')")
    @Log(title = "商机管理", businessType = BusinessType.INSERT)
    @PutMapping
    public AjaxResult editBusiness(@RequestBody Business business) {
        return businessService.editBusiness(business);
    }

    /**
     * 查询所有渠道
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:business:list')")
    @GetMapping("/channel")
    public AjaxResult getAllChannels() {
        return AjaxResult.success(channelService.list());
    }

    /**
     * 查询所有活动
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:business:add')")
    @GetMapping("/activity/{channelId}")
    public AjaxResult getAllActivities(@PathVariable("channelId") Integer channelId) {
        return AjaxResult.success(activityService.list(Wrappers.<Activity>lambdaQuery().eq(Activity::getChannelId, channelId)));
    }

    /**
     * 根据课程类型列出对应课程
     *
     * @param type
     * @return
     */
    @PreAuthorize("hasAnyPermissions('tienchin:business:follow','tienchin:business:view')")
    @GetMapping("/course/{type}")
    public AjaxResult getCourseByCourseType(@PathVariable("type") Integer type) {
        return courseService.selectCourseByCourseType(type);
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/{businessId}")
    @PreAuthorize("hasAnyPermissions('tienchin:business:follow','tienchin:business:view')")
    public AjaxResult getBusinessById(@PathVariable("businessId") Integer id) {
        return businessService.getBusinessById(id);
    }

    /**
     * 保存客户详细信息
     *
     * @param businessFollow
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:business:follow')")
    @PutMapping("/follow")
    public AjaxResult insertBusinessFollow(@RequestBody @Validated BusinessFollow businessFollow) {
        return businessService.insertBusinessFollow(businessFollow);
    }

    /**
     * 根据商机`Id`获取商机摘要信息
     *
     * @param businessId
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:business:query')")
    @GetMapping("/summary/{businessId}")
    public AjaxResult getBusinessSummaryById(@PathVariable("businessId") Integer businessId) {
        return businessService.getBusinessSummaryById(businessId);
    }

    @DeleteMapping("/businessIds")
    public AjaxResult deleteBusinessByIds(@PathVariable("businessIds") Long[] ids) {
        return businessService.removeBusinessByIds(ids);
    }

}
