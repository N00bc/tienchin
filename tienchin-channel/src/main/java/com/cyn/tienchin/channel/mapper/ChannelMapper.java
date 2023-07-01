package com.cyn.tienchin.channel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.tienchin.channel.domain.Channel;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyn
 * @since 2023-07-01
 */
public interface ChannelMapper extends BaseMapper<Channel> {

    List<Channel> selectChannelList();
}