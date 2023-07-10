package com.cyn.tienchin.clue.service;

import com.cyn.tienchin.clue.domain.FollowRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.common.core.domain.AjaxResult;

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
}
