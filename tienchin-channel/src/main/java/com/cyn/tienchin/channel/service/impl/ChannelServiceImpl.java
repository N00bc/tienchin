package com.cyn.tienchin.channel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.channel.domain.Channel;
import com.cyn.tienchin.channel.domain.vo.ChannelVo;
import com.cyn.tienchin.channel.mapper.ChannelMapper;
import com.cyn.tienchin.channel.service.IChannelService;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-01
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements IChannelService {
    @Autowired
    private ChannelMapper channelMapper;

    /**
     * 查询所有的渠道
     *
     * @return
     */
    @Override
    public List<Channel> selectChannelList() {

        return channelMapper.selectChannelList();
    }

    /**
     * 新增渠道
     *
     * @param channelVo
     * @return
     */
    @Override
    public AjaxResult insertChannel(ChannelVo channelVo) {
        Channel channel = new Channel();
        BeanUtils.copyProperties(channelVo, channel);
        // where channel_name = channel.getName()
        LambdaQueryWrapper<Channel> lambdaQueryWrapper = Wrappers.<Channel>lambdaQuery().eq(Channel::getChannelName, channel.getChannelName());
        Channel one = getOne(lambdaQueryWrapper);
        // 是否存在同名渠道
        if (one != null) {
            // 存在同名渠道
            return AjaxResult.error("存在未删除的同名渠道,添加失败");
        }

        return save(channel) ? AjaxResult.success("添加渠道成功") : AjaxResult.error("添加渠道失败");
    }

    /**
     * 更新渠道
     *
     * @param channelVo
     * @return
     */
    @Override
    public AjaxResult updateChannel(ChannelVo channelVo) {
        Channel channel = new Channel();
        BeanUtils.copyProperties(channelVo, channel);
        return updateById(channel)?AjaxResult.success("更新成功"):AjaxResult.error("更新失败");
    }
}
