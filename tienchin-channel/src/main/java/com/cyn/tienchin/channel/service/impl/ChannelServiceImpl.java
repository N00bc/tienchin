package com.cyn.tienchin.channel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.channel.domain.Channel;
import com.cyn.tienchin.channel.domain.vo.ChannelVo;
import com.cyn.tienchin.channel.mapper.ChannelMapper;
import com.cyn.tienchin.channel.service.IChannelService;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.exception.ServiceException;
import com.cyn.tienchin.common.utils.poi.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
     * @param channelVo
     * @return
     */
    @Override
    public List<Channel> selectChannelList(ChannelVo channelVo) {

        return channelMapper.selectChannelList(channelVo);
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
        return updateById(channel) ? AjaxResult.success("更新成功") : AjaxResult.error("更新失败");
    }

    /**
     * 将Excel数据导入
     *
     * @param file          上传的excel文件
     * @param updateSupport 是否覆盖已存在数据
     * @return
     */
    @Override
    public AjaxResult importChannel(MultipartFile file, boolean updateSupport) {
        ExcelUtil<Channel> excelUtil = new ExcelUtil<Channel>(Channel.class);
        List<Channel> channelList = null;
        try {
            channelList = excelUtil.importExcel(file.getInputStream());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServiceException("文件导入失败");
        }
        if (updateSupport) {
            // 需要更新channels
            updateBatchById(channelList);
        } else {
            // 插入channels
            // 防止 id 重复
            channelList.forEach(channel -> channel.setChannelId(null));
            saveBatch(channelList);
        }
        return AjaxResult.success("数据导入成功");

    }
}
