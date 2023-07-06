package com.cyn.tienchin.course.mapper;

import com.cyn.tienchin.course.domain.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.tienchin.course.domain.vo.CourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyn
 * @since 2023-07-06
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 查询课程列表
     * @param courseVo
     * @return
     */
    List<CourseVo> selectCourseVoList(@Param("courseVo") CourseVo courseVo);
}
