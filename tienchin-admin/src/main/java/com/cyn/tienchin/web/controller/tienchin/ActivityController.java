package com.cyn.tienchin.web.controller.tienchin;

import com.cyn.tienchin.activity.domain.Activity;
import com.cyn.tienchin.activity.domain.vo.ActivityVo;
import com.cyn.tienchin.activity.service.IActivityService;
import com.cyn.tienchin.channel.domain.Channel;
import com.cyn.tienchin.channel.service.IChannelService;
import com.cyn.tienchin.common.annotation.Log;
import com.cyn.tienchin.common.core.controller.BaseController;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.core.page.TableDataInfo;
import com.cyn.tienchin.common.enums.BusinessType;
import com.cyn.tienchin.common.utils.poi.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cyn
 * @since 2023-07-04
 */
@RestController
@RequestMapping("/tienchin/activity")
public class ActivityController extends BaseController {
    @Autowired
    private IActivityService activityService;
    @Autowired
    private IChannelService channelService;

    @PreAuthorize("hasPermission('tienchin:activity:add')")
    @GetMapping("/channel/list")
    public AjaxResult channelList() {
        List<Channel> list = channelService.list();
        return AjaxResult.success(list);
    }

    /**
     * 分页展示活动信息
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(ActivityVo activityVo) {
        startPage();
        List<ActivityVo> list = activityService.selectActivityVoList(activityVo);
        return getDataTable(list);
    }

    /**
     * 新增活动
     *
     * @param activityVo
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:activity:add')")
    @Log(title = "活动管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ActivityVo activityVo) {
        return activityService.insertActivity(activityVo);

    }

    /**
     * 修改保存活动
     */
    @PreAuthorize("hasPermission('tienchin:activity:edit')")
    @Log(title = "活动管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody ActivityVo activityVo) {
        return activityService.updateActivity(activityVo);
    }

    /**
     * 根据活动id获取活动信息
     *
     * @param activityId
     * @return
     */
    @GetMapping("/{activityId}")
    @PreAuthorize("hasPermission('tienchin:activity:query')")
    public AjaxResult getInfo(@PathVariable("activityId") Integer activityId) {
        return AjaxResult.success(activityService.getById(activityId));
    }

    private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    /**
     * 根据id删除活动
     *
     * @param activityIds
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:activity:remove')")
    @Log(title = "活动管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{activityIds}")
    public AjaxResult remove(@PathVariable("activityIds") Integer[] activityIds) {
        logger.info("activityIds:{}", activityIds);
        return AjaxResult.success(activityService.removeBatchByIds(new ArrayList<>(Arrays.asList(activityIds))));
    }

    /**
     * 导出模板
     *
     * @param response
     * @param activityVo
     */
    @Log(title = "活动管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("hasPermission('tienchin:activity:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, ActivityVo activityVo) {
        List<Activity> list = activityService.selectActivityList(activityVo);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        util.exportExcel(response, list, "活动数据");
    }

    /**
     * 活动导入模板excel
     *
     * @param response
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        util.importTemplateExcel(response, "活动数据");
    }

    @Log(title = "活动管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("hasPermission('tienchin:activity:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        return activityService.importActivity(file, updateSupport);
    }

}
