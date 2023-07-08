package com.cyn.tienchin.clue.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.cyn.tienchin.common.validator.AddGroup;
import com.cyn.tienchin.common.validator.EditGroup;

import javax.validation.constraints.NotNull;
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
@TableName("tienchin_clue")
public class Clue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 线索id
     */
    @TableId(value = "clue_id", type = IdType.AUTO)
    private Integer clueId;

    /**
     * 客户名
     */
    @NotNull(groups = {EditGroup.class, AddGroup.class}, message = "{clue.customerName.notnull}")
    private String customerName;

    /**
     * 渠道名称
     */
    private Integer channelId;

    /**
     * 活动名称
     */
    private Integer activityId;

    /**
     * 性别 0=男,1=女,2=未知
     */
    private Integer gender;

    /**
     * 手机号码
     */
    @NotNull(groups = {EditGroup.class, AddGroup.class}, message = "{clue.phoneNumber.notnull}")
    private String phoneNumber;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * qq号
     */
    private String qq;

    /**
     * 意向等级 1~4 由强到弱
     */
    private Integer level;

    /**
     * 私教课程
     */
    private Integer subject;

    /**
     * 线索状态 1=已分配,2=跟进中,3=已回收,4=伪线索
     */
    private Integer status;

    /**
     * 伪线索失败次数，最大三次
     */
    private Integer failCount;

    /**
     * 下次跟进时间 默认是在创建时间后的24小时内
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime nextTime;

    /**
     * 线索失效时间，DDL
     */
    private LocalDateTime endTime;

    /**
     * 是否需要转派 1=需要,0=不需要
     */
    private Integer transfer;

    /**
     * 备注
     */
    private String remark;

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
     * 是否删除 0=未删除,2=已删除
     */
    @TableLogic
    private Integer delFlag;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public LocalDateTime getNextTime() {
        return nextTime;
    }

    public void setNextTime(LocalDateTime nextTime) {
        this.nextTime = nextTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getTransfer() {
        return transfer;
    }

    public void setTransfer(Integer transfer) {
        this.transfer = transfer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "clueId=" + clueId +
                ", customerName='" + customerName + '\'' +
                ", channelId=" + channelId +
                ", activityId=" + activityId +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", wechat='" + wechat + '\'' +
                ", qq='" + qq + '\'' +
                ", level=" + level +
                ", subject=" + subject +
                ", status=" + status +
                ", failCount=" + failCount +
                ", nextTime=" + nextTime +
                ", endTime=" + endTime +
                ", transfer=" + transfer +
                ", remark='" + remark + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                '}';
    }
}
