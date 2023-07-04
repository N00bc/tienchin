package com.cyn.tienchin.web.controller.tienchin;

import com.cyn.tienchin.channel.domain.Channel;
import com.cyn.tienchin.channel.domain.vo.ChannelVo;
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
 * 渠道相关Controller
 * </p>
 *
 * @author cyn
 * @since 2023-07-01
 */
@RestController
@RequestMapping("/tienchin/channel")
public class ChannelController extends BaseController {
    @Autowired
    private IChannelService channelService;

    /**
     * 分页展示渠道信息
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:channel:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChannelVo channelVo) {
        startPage();
        List<Channel> list = channelService.selectChannelList(channelVo);
        return getDataTable(list);
    }

    /**
     * 新增渠道
     *
     * @param channelVo
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:channel:add')")
    @Log(title = "渠道管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ChannelVo channelVo) {

        return channelService.insertChannel(channelVo);

    }

    /**
     * 修改保存渠道
     */
    @PreAuthorize("hasPermission('tienchin:channel:edit')")
    @Log(title = "渠道管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody ChannelVo channelVo) {
        return channelService.updateChannel(channelVo);
    }

    /**
     * 根据渠道id获取渠道信息
     *
     * @param channelId
     * @return
     */
    @GetMapping("/{channelId}")
    @PreAuthorize("hasPermission('tienchin:channel:query')")
    public AjaxResult getInfo(@PathVariable("channelId") Integer channelId) {
        return AjaxResult.success(channelService.getById(channelId));
    }

    private static final Logger logger = LoggerFactory.getLogger(ChannelController.class);

    /**
     * 根据id删除渠道
     *
     * @param channelIds
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:channel:remove')")
    @Log(title = "渠道管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{channelIds}")
    public AjaxResult remove(@PathVariable("channelIds") Integer[] channelIds) {
        logger.info("channelIds:{}", channelIds);
        return AjaxResult.success(channelService.removeBatchByIds(new ArrayList<>(Arrays.asList(channelIds))));
    }

    /**
     * 导出模板
     * @param response
     * @param channelVo
     */
    @Log(title = "渠道管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("hasPermission('tienchin:channel:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChannelVo channelVo) {
        List<Channel> list = channelService.selectChannelList(channelVo);
        ExcelUtil<Channel> util = new ExcelUtil<Channel>(Channel.class);
        util.exportExcel(response, list, "渠道数据");
    }

    /**
     * 渠道导入模板excel
     * @param response
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<Channel> util = new ExcelUtil<Channel>(Channel.class);
        util.importTemplateExcel(response, "渠道数据");
    }
    @Log(title = "渠道管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("hasPermission('tienchin:channel:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        return channelService.importChannel(file,updateSupport);
    }
}
