package com.cyn.tienchin.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.course.domain.Course;
import com.cyn.tienchin.course.domain.vo.CourseVo;
import com.cyn.tienchin.course.mapper.CourseMapper;
import com.cyn.tienchin.course.service.ICourseService;
import org.springframework.beans.BeanUtils;
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
 * @since 2023-07-06
 */
@Service
@Transactional
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询课程列表
     *
     * @param courseVo
     * @return
     */
    @Override
    public List<CourseVo> selectCourseVoList(CourseVo courseVo) {
        List<CourseVo> courseVoList = courseMapper.selectCourseVoList(courseVo);
        return courseVoList;
    }

    /**
     * 插入课程
     *
     * @param courseVo
     * @return
     */
    @Override
    public AjaxResult insertCourse(CourseVo courseVo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseVo, course);
        LambdaQueryWrapper<Course> lambdaQueryWrapper = Wrappers.<Course>lambdaQuery().eq(Course::getCourseName, course.getCourseName());
        Course one = getOne(lambdaQueryWrapper);
        if (one != null) {
            return AjaxResult.error("课程名已存在，请重新添加");
        }
        save(course);
        return AjaxResult.success("新增课程成功");
    }

    /**
     * 更新课程信息
     *
     * @param courseVo
     * @return
     */
    @Override
    public AjaxResult updateCourse(CourseVo courseVo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseVo, course);
        updateById(course);
        return AjaxResult.success("更新课程成功");
    }

    /**
     * 根据课程类型选择课程
     *
     * @param type
     * @return
     */
    @Override
    public AjaxResult selectCourseByCourseType(Integer type) {
        List<Course> list = list(Wrappers.<Course>lambdaQuery().eq(Course::getType, type));
        return AjaxResult.success(list);
    }
}
