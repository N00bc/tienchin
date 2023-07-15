package com.cyn.tienchin.web.controller.tienchin.contract;

import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 合同实体 前端控制器
 * </p>
 *
 * @author cyn
 * @since 2023-07-15
 */
@RestController
@RequestMapping("/tienchin/contract")
public class ContractController {
    @Autowired
    private ICourseService courseService;

    /**
     * 根据`type`查找对应课程
     *
     * @param type
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:add')")
    @GetMapping("/course/{type}")
    public AjaxResult listCourseByCourseType(@PathVariable("type") Integer type) {
        return courseService.selectCourseByCourseType(type);
    }

    @PreAuthorize("hasPermission('tienchin:contract:add')")
    @PostMapping("/upload")
    public AjaxResult uploadContractFile(MultipartFile multipartFile) {
        return null;
    }
}
