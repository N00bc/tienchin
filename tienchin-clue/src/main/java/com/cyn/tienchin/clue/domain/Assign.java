package com.cyn.tienchin.clue.domain;

import com.baomidou.mybatisplus.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 线索 商机明细表
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
@TableName("tienchin_assign")
public class Assign implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键字段
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 1=线索,2=商机
     */
    private Integer type;

    /**
     * 线索或者商机的ID
     */
    @NotNull(message = "{assign.assignId.notnull}")
    private Integer assignId;

    /**
     * 线索当前所属用户id
     */
    @NotNull(message = "{assign.userId.notnull}")
    private Long userId;

    /**
     * 线索所属用户名
     */
    @NotNull(message = "{assign.userName.notnull}")
    private String userName;

    /**
     * 线索所属部门id
     */
    private Long  deptId;

    /**
     * 是否当前最新信息 1=是,0=不是
     */
    private Integer latest;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 是否被删除 0=未删除,2=已删除
     */
    @TableLogic
    private Integer delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getLatest() {
        return latest;
    }

    public void setLatest(Integer latest) {
        this.latest = latest;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Assign{" +
                "id = " + id +
                ", type = " + type +
                ", assignId = " + assignId +
                ", userId = " + userId +
                ", userName = " + userName +
                ", deptId = " + deptId +
                ", latest = " + latest +
                ", createTime = " + createTime +
                ", updateTime = " + updateTime +
                ", createBy = " + createBy +
                ", updateBy = " + updateBy +
                ", delFlag = " + delFlag +
                "}";
    }
}
