package com.cyn.tienchin.web.controller.tienchin;

import com.cyn.tienchin.common.annotation.Log;
import com.cyn.tienchin.common.core.controller.BaseController;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.core.page.TableDataInfo;
import com.cyn.tienchin.common.enums.BusinessType;
import com.cyn.tienchin.common.utils.poi.ExcelUtil;
import com.cyn.tienchin.common.validator.AddGroup;
import com.cyn.tienchin.common.validator.EditGroup;
import com.cyn.tienchin.course.domain.vo.CourseVo;
import com.cyn.tienchin.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cyn
 * @since 2023-07-06
 */
@RestController
@RequestMapping("/tienchin/course")
public class CourseController extends BaseController {
    @Autowired
    private ICourseService courseService;

    /**
     * 课程列表
     *
     * @param courseVo
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseVo courseVo) {
        startPage();
        List<CourseVo> list = courseService.selectCourseVoList(courseVo);
        return getDataTable(list);
    }

    /**
     * 新增渠道
     *
     * @param courseVo
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:course:add')")
    @Log(title = "课程管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated(AddGroup.class) @RequestBody CourseVo courseVo) {
        return courseService.insertCourse(courseVo);
    }

    /**
     * 根据活动id获取课程信息
     *
     * @param courseId
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:course:query')")
    @GetMapping("/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Integer courseId) {
        return AjaxResult.success(courseService.getById(courseId));
    }

    /**
     * 修改保存课程
     */
    @PreAuthorize("hasPermission('tienchin:course:edit')")
    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated(EditGroup.class) @RequestBody CourseVo courseVo) {
        return courseService.updateCourse(courseVo);
    }

    /**
     * 根据id删除活动
     *
     * @param courseIds
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:course:remove')")
    @Log(title = "活动管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable("courseIds") Integer[] courseIds) {
        logger.info("courseIds:{}", courseIds);
        return AjaxResult.success(courseService.removeBatchByIds(new ArrayList<>(Arrays.asList(courseIds))));
    }

    /**
     * 导出为Excel
     *
     * @param response
     * @param courseVo
     */
    @Log(title = "课程管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("hasPermission('tienchin:course:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseVo courseVo) {
        List<CourseVo> list = courseService.selectCourseVoList(courseVo);
        ExcelUtil<CourseVo> util = new ExcelUtil<CourseVo>(CourseVo.class);
        util.exportExcel(response, list, "课程数据");
    }

}
