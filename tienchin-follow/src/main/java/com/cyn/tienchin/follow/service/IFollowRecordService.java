package com.cyn.tienchin.follow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.follow.domain.FollowRecord;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
public interface IFollowRecordService extends IService<FollowRecord> {

    /**
     * 根据线索id获取所有线索记录
     * @param clueId
     * @return
     */
    AjaxResult getFollowRecordByClueId(Integer clueId);

    /**
     * 根据`businessId`获取所有跟踪记录
     * @param businessId
     * @return
     */
    AjaxResult getFollowRecordByBusinessId(Integer businessId);
}
