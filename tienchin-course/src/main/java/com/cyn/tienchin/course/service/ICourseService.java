package com.cyn.tienchin.course.service;

import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.course.domain.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.course.domain.vo.CourseVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyn
 * @since 2023-07-06
 */
public interface ICourseService extends IService<Course> {

    /**
     * 查询课程列表
     *
     * @param courseVo
     * @return
     */
    List<CourseVo> selectCourseVoList(CourseVo courseVo);

    /**
     * 插入课程
     *
     * @param courseVo
     * @return
     */
    AjaxResult insertCourse(CourseVo courseVo);

    /**
     * 更新课程信息
     *
     * @param courseVo
     * @return
     */
    AjaxResult updateCourse(CourseVo courseVo);

    /**
     * 根据课程类型选择课程
     * @param type
     * @return
     */
    AjaxResult selectCourseByCourseType(Integer type);
}
