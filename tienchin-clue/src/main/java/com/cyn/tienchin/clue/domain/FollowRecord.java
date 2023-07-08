package com.cyn.tienchin.clue.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
@TableName("tienchin_follow_record")
public class FollowRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 线索记录id
     */
    private Integer recordId;

    /**
     * 跟进记录 1=线索,2=商机
     */
    private Boolean type;

    /**
     * 线索或商机id
     */
    private Integer assignId;

    /**
     * 备注
     */
    private String info;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除 0=未删除,2=删除
     */
    private Boolean delFlag;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "FollowRecord{" +
                "recordId = " + recordId +
                ", type = " + type +
                ", assignId = " + assignId +
                ", info = " + info +
                ", createBy = " + createBy +
                ", updateBy = " + updateBy +
                ", createTime = " + createTime +
                ", updateTime = " + updateTime +
                ", delFlag = " + delFlag +
                "}";
    }
}
