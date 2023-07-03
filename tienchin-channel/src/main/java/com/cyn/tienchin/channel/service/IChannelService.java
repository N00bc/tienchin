package com.cyn.tienchin.channel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.channel.domain.Channel;
import com.cyn.tienchin.channel.domain.vo.ChannelVo;
import com.cyn.tienchin.common.core.domain.AjaxResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyn
 * @since 2023-07-01
 */
public interface IChannelService extends IService<Channel> {

    /**
     * 查询所有的渠道
     * @return
     */
    List<Channel> selectChannelList();

    /**
     * 新增渠道
     * @param channelVo
     * @return
     */
    AjaxResult insertChannel(ChannelVo channelVo);

    /**
     * 更新渠道
     * @param channelVo
     * @return
     */
    AjaxResult updateChannel(ChannelVo channelVo);
}
