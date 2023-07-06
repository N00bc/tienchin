package com.cyn.tienchin.activity.mapper;

import com.cyn.tienchin.activity.domain.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.tienchin.activity.domain.vo.ActivityVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
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
    List<ActivityVo> selectActivityVoList(@Param("activityVo") ActivityVo activityVo);

    /**
     * 更新Activity
     * @param activity
     * @param username
     */
    void updateActivity(@Param("activity") Activity activity, @Param("now") LocalDateTime now,@Param("user") String username);

}
