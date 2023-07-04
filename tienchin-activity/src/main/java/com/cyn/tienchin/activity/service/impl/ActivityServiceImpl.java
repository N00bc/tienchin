package com.cyn.tienchin.activity.service.impl;

import com.cyn.tienchin.activity.domain.Activity;
import com.cyn.tienchin.activity.mapper.ActivityMapper;
import com.cyn.tienchin.activity.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-04
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

}
