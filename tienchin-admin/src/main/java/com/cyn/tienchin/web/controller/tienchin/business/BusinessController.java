package com.cyn.tienchin.web.controller.tienchin.business;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cyn.tienchin.activity.domain.Activity;
import com.cyn.tienchin.activity.service.IActivityService;
import com.cyn.tienchin.business.domain.Business;
import com.cyn.tienchin.business.domain.BusinessSummary;
import com.cyn.tienchin.business.service.IBusinessService;
import com.cyn.tienchin.channel.service.IChannelService;
import com.cyn.tienchin.common.annotation.Log;
import com.cyn.tienchin.common.core.controller.BaseController;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.core.page.TableDataInfo;
import com.cyn.tienchin.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasPermission('tienchin:business:list')")
    @GetMapping("/list")
    public TableDataInfo list() {
        startPage();
        List<BusinessSummary> list = businessService.selectBusinessSummaryList();
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
}
