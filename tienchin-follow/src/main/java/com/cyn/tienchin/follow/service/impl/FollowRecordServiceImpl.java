package com.cyn.tienchin.follow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.common.constant.TienChinConstants;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.follow.domain.FollowRecord;
import com.cyn.tienchin.follow.mapper.FollowRecordMapper;
import com.cyn.tienchin.follow.service.IFollowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
@Service
@Transactional
public class FollowRecordServiceImpl extends ServiceImpl<FollowRecordMapper, FollowRecord> implements IFollowRecordService {
    @Autowired
    private FollowRecordMapper followRecordMapper;

    /**
     * 根据线索id获取所有线索记录
     *
     * @param clueId
     * @return
     */
    @Override
    public AjaxResult getFollowRecordByClueId(Integer clueId) {
        LambdaQueryWrapper<FollowRecord> lambdaQueryWrapper = Wrappers.<FollowRecord>lambdaQuery()
                .eq(FollowRecord::getAssignId, clueId)
                .eq(FollowRecord::getType, TienChinConstants.CLUE_TYPE)
                .orderByDesc(FollowRecord::getUpdateTime)
                .orderByDesc(FollowRecord::getCreateTime);
        List<FollowRecord> list = list(lambdaQueryWrapper);
        return AjaxResult.success(list);
    }
}
