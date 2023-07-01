package com.cyn.tienchin.channel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.channel.domain.Channel;
import com.cyn.tienchin.channel.mapper.ChannelMapper;
import com.cyn.tienchin.channel.service.IChannelService;
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
}
