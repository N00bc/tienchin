package com.cyn.tienchin.activity.service;

import com.cyn.tienchin.activity.domain.Activity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.activity.domain.vo.ActivityVo;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyn
 * @since 2023-07-04
 */
public interface IActivityService extends IService<Activity> {

    /**
     * 查询活动信息
     * @param activityVo
     * @return
     */
    List<ActivityVo> selectActivityVoList(ActivityVo activityVo);

    /**
     *
     * @param activityVo
     * @return
     */
    List<Activity> selectActivityList(ActivityVo activityVo);

    /**
     * 新增活动
     * @param activityVo
     * @return
     */
    AjaxResult insertActivity(ActivityVo activityVo);

    /**
     * 更新活动
     * @param activityVo
     * @return
     */
    AjaxResult updateActivity(ActivityVo activityVo);

    /**
     * 导入活动excel
     * @param file
     * @param updateSupport
     * @return
     */
    AjaxResult importActivity(MultipartFile file, boolean updateSupport);
}
