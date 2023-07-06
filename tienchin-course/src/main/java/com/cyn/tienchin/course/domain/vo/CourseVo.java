package com.cyn.tienchin.course.domain.vo;

import com.cyn.tienchin.common.core.domain.BaseEntity;
import com.cyn.tienchin.common.validator.AddGroup;
import com.cyn.tienchin.common.validator.EditGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @author Godc
 * @description:
 * @date 2023/7/06/0006 11:28
 */
public class CourseVo extends BaseEntity {
    /**
     * 课程id
     */
    @NotNull(message = "{course.courseId.notnull}",groups = EditGroup.class)
    private Integer courseId;

    /**
     * 课程名
     */
    @NotNull(message = "{course.courseName.notnull}",groups = {EditGroup.class, AddGroup.class})
    @Size(min = 0, max = 30, message = "{course.courseName.size}", groups = {EditGroup.class, AddGroup.class})
    private String courseName;

    /**
     * 课程类型 1.舞蹈类 2.游泳类 3.拳击类
     */
    @NotNull(message = "{course.type.notnull}",groups = {EditGroup.class, AddGroup.class})
    @Max(value = 3, message = "{course.type.invalid}", groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1, message = "{course.type.invalid}", groups = {EditGroup.class, AddGroup.class})
    private Integer type;

    /**
     * 课程价格
     */
    @NotNull(message = "{course.price.notnull}",groups = {EditGroup.class, AddGroup.class})
    @Min(value = 0, message = "{course.price.invalid}", groups = {EditGroup.class, AddGroup.class})
    private BigDecimal price;

    @JsonIgnore
    private BigDecimal minPrice;
    @JsonIgnore
    private BigDecimal maxPrice;

    /**
     * 适用人群
     */
    @NotNull(message = "{course.apply.notnull}",groups = {EditGroup.class, AddGroup.class})
    @Max(value = 4, message = "{course.apply.invalid}", groups = {EditGroup.class, AddGroup.class})
    @Min(value = 1, message = "{course.apply.invalid}", groups = {EditGroup.class, AddGroup.class})
    private Integer apply;

    /**
     * 课程简介
     */
    @NotBlank(message = "{course.info.notblank}", groups = {EditGroup.class, AddGroup.class})
    @Size(min = 0, max = 255, message = "{course.info.size}", groups = {EditGroup.class, AddGroup.class})
    private String info;

    /**
     * 逻辑删除字段 0未删除 2已删除
     */
    private String delFlag;

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getApply() {
        return apply;
    }

    public void setApply(Integer apply) {
        this.apply = apply;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
