package com.cyn.tienchin.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cyn.tienchin.activity.domain.Activity;
import com.cyn.tienchin.activity.domain.vo.ActivityVo;
import com.cyn.tienchin.activity.mapper.ActivityMapper;
import com.cyn.tienchin.activity.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Activity> selectActivityList(ActivityVo activityVo) {
        List<ActivityVo> activityVoList = activityMapper.selectActivityVoList(activityVo);
        List<Activity> activityList = activityVoList.stream().map(vo -> {
            Activity activity = new Activity();
            BeanUtils.copyProperties(vo, activity);
            return activity;
        }).collect(Collectors.toList());
        return activityList;
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
        LambdaQueryWrapper<Activity> lambdaQueryWrapper = Wrappers.<Activity>lambdaQuery().eq(Activity::getActivityName, activity.getActivityName());
        Activity one = getOne(lambdaQueryWrapper);
        // 是否存在同名方法
        if (one != null) {
            // 存在同名活动
            return AjaxResult.error("存在未删除的同名活动,添加失败");
        }
        return save(activity) ? AjaxResult.success("添加活动成功") : AjaxResult.error("添加活动失败");
    }

    /**
     * 更新活动
     *
     * @param activityVo
     * @return
     */
    @Override
    public AjaxResult updateActivity(ActivityVo activityVo) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityVo, activity);
        return updateById(activity) ? AjaxResult.success("更新成功") : AjaxResult.error("更新失败");
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
