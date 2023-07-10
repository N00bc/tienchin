package com.cyn.tienchin.web.controller.tienchin.clue;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cyn.tienchin.activity.domain.Activity;
import com.cyn.tienchin.activity.service.IActivityService;
import com.cyn.tienchin.channel.service.IChannelService;
import com.cyn.tienchin.clue.domain.Clue;
import com.cyn.tienchin.clue.domain.vo.ClueDetails;
import com.cyn.tienchin.clue.domain.vo.ClueSummary;
import com.cyn.tienchin.clue.service.IClueService;
import com.cyn.tienchin.common.annotation.Log;
import com.cyn.tienchin.common.core.controller.BaseController;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.core.page.TableDataInfo;
import com.cyn.tienchin.common.enums.BusinessType;
import com.cyn.tienchin.common.validator.AddGroup;
import com.cyn.tienchin.system.service.ISysUserService;
import io.swagger.models.auth.In;
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
 * @since 2023-07-07
 */
@RestController
@RequestMapping("/tienchin/clue")
public class ClueController extends BaseController {
    @Autowired
    private IClueService clueService;
    @Autowired
    private IChannelService channelService;
    @Autowired
    private IActivityService activityService;
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 新增线索
     *
     * @param clue
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:clue:add')")
    @Log(title = "线索管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated(AddGroup.class) @RequestBody Clue clue) {
        return clueService.insertClue(clue);
    }

    /**
     * 查询所有渠道
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:clue:add')")
    @GetMapping("/channel")
    public AjaxResult getAllChannels() {
        return AjaxResult.success(channelService.list());
    }

    /**
     * 查询所有
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:clue:add')")
    @GetMapping("/activity/{channelId}")
    public AjaxResult getAllActivities(@PathVariable("channelId") Integer channelId) {
        return AjaxResult.success(activityService.list(Wrappers.<Activity>lambdaQuery().eq(Activity::getChannelId, channelId)));
    }

    /**
     * 课程列表
     *
     * @param
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:clue:list')")
    @GetMapping("/list")
    public TableDataInfo list() {
        startPage();
        List<ClueSummary> list = clueService.selectClueSummaryList();
        return getDataTable(list);
    }

    /**
     * 根据部门id查询部门员工信息
     *
     * @param deptId
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:clue:assign')")
    @GetMapping("/users/{deptId}")
    public AjaxResult getUserListByDeptId(@PathVariable("deptId") Long deptId) {
        return sysUserService.getUserByDeptId(deptId);
    }
    /**
     * 根据线索Id获取线索信息
     *
     * @param clueId
     * @return
     */
    @PreAuthorize("hasAnyPermissions('tienchin:clue:view','tienchin:clue:follow')")
    @GetMapping("/{clueId}")
    public AjaxResult getClueDetailsByClueId(@PathVariable("clueId") Long clueId) {
        return clueService.getClueDetailsByClueId(clueId);
    }

    /**
     * 更新`线索`
     * @param clueDetails
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:clue:follow')")
    @PutMapping("/follow")
    public AjaxResult updateClueFollow(@RequestBody ClueDetails clueDetails){
        return clueService.updateClueFollow(clueDetails);
    }

    /**
     * `无效线索`记录提交
     * @param clueDetails
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:clue:follow')")
    @PutMapping("/invalidate")
    public AjaxResult updateInvalidateClueFollow(@RequestBody ClueDetails clueDetails){
        return clueService.updateInvalidateClueFollow(clueDetails);
    }
    @PreAuthorize("hasPermission('tienchin:clue:query')")
    @GetMapping("/summary/{clueId}")
    public AjaxResult getClueSummary(@PathVariable("clueId")Integer clueId){
        return clueService.getClueSummary(clueId);
    }

}
