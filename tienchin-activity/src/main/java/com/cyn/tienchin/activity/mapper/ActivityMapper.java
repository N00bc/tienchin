package com.cyn.tienchin.activity.mapper;

import com.cyn.tienchin.activity.domain.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.tienchin.activity.domain.vo.ActivityVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyn
 * @since 2023-07-04
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 根据字段查询活动列表
     * @param activityVo
     * @return
     */
    List<ActivityVo> selectActivityVoList(ActivityVo activityVo);

    List<Activity> selectActivityList(ActivityVo activityVo);
}
