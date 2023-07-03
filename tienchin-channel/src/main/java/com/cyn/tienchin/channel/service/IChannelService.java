package com.cyn.tienchin.channel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.channel.domain.Channel;
import com.cyn.tienchin.channel.domain.vo.ChannelVo;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

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
     * @param channelVo
     */
    List<Channel> selectChannelList(ChannelVo channelVo);

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

    /**
     * 将Excel数据导入
     * @param file
     * @param updateSupport
     * @return
     */
    AjaxResult importChannel(MultipartFile file, boolean updateSupport);
}
