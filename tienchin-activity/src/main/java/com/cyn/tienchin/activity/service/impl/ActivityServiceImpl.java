package com.cyn.tienchin.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.activity.domain.Activity;
import com.cyn.tienchin.activity.domain.vo.ActivityVo;
import com.cyn.tienchin.activity.mapper.ActivityMapper;
import com.cyn.tienchin.activity.service.IActivityService;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-04
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 查询活动信息
     *
     * @param activityVo
     * @return
     */
    @Override
    public List<ActivityVo> selectActivityVoList(ActivityVo activityVo) {
        expireActivity();
        List<ActivityVo> activityVos = activityMapper.selectActivityVoList(activityVo);
        return activityVos;
    }

    /**
     * 将endTime > Date.now()的活动 status 属性置0
     * UPDATE tienchin_activity
     * SET STATUS = 0
     * WHERE
     * 	STATUS = 1
     * 	AND endTime < Date.now()
     * 	AND del_flag = 0
     * @return
     */
    public boolean expireActivity() {
        LambdaUpdateWrapper<Activity> lambdaUpdateWrapper = Wrappers.<Activity>lambdaUpdate()
                .set(Activity::getStatus, 0)
                .eq(Activity::getStatus, 1)
                .lt(Activity::getEndTime, LocalDateTime.now());
        return update(lambdaUpdateWrapper);
    }

    @Override
    public List<Activity> selectActivityList(ActivityVo activityVo) {
        return null;
    }

    /**
     * 新增活动
     *
     * @param activityVo
     * @return
     */
    @Override
    public AjaxResult insertActivity(ActivityVo activityVo) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityVo, activity);
        return save(activity) ? AjaxResult.success("添加活动成功") : AjaxResult.error("添加活动失败");
    }

    /**
     * 修改活动
     *
     * @param activityVo
     * @return
     */
    @Override
    public AjaxResult updateActivity(ActivityVo activityVo) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityVo, activity);
        String username = SecurityUtils.getUsername();
        activityMapper.updateActivity(activity,LocalDateTime.now(),username);
        return AjaxResult.success("修改成功");
    }

    /**
     * 导入活动excel
     *
     * @param file
     * @param updateSupport
     * @return
     */
    @Override
    public AjaxResult importActivity(MultipartFile file, boolean updateSupport) {
        return null;
    }
}
