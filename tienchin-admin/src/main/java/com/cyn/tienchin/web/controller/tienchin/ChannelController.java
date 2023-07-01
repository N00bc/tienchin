package com.cyn.tienchin.web.controller.tienchin;

import com.cyn.tienchin.channel.domain.Channel;
import com.cyn.tienchin.channel.service.IChannelService;
import com.cyn.tienchin.common.core.controller.BaseController;
import com.cyn.tienchin.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PreAuthorize("hasPermission('tienchin:channel:list')")
    @GetMapping("/list")
    public TableDataInfo list() {
        startPage();
        List<Channel> list = channelService.selectChannelList();
        return getDataTable(list);
    }

}
