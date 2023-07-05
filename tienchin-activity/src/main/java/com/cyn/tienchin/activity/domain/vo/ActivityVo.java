package com.cyn.tienchin.activity.domain.vo;

import com.cyn.tienchin.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * @author Godc
 * @description:
 * @date 2023/7/04/0004 15:27
 */
public class ActivityVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer activityId;

    /**
     * 活动名称
     */
    @NotBlank(message = "{activity.activityName.notblank}")
    @Size(min = 0, max = 30, message = "{activity.activityName.size}")
    private String activityName;

    /**
     * 渠道名
     */
    private String channelName;
    /**
     * 渠道ID
     */
    @NotNull(message = "{activity.channelId.notnull}")
    private Integer channelId;
    /**
     * 活动简介
     */
    @NotBlank(message = "{activity.info.notblank}")
    @Size(min = 0, max = 255,message = "{activity.info.size}")
    private String info;

    /**
     * 活动类型 1折扣券 2代金券
     */
    @NotNull(message = "{activity.type.notnull}")
    private Byte type;

    /**
     * 折扣券
     */
    @Max(value = 10, message = "{activity.discount.invalid}")
    @Min(value = 0, message = "{activity.discount.invalid}")
    private Double discount;

    /**
     * 代金券
     */
    @Min(value = 0,message = "{activity.voucher.invalid}")
    private Double voucher;

    /**
     * 活动状态 1正常 0禁用
     */
    @Max(value = 1, message = "{{activity.status.invalid}}")
    @Min(value = 0, message = "{activity.status.invalid}")
    private Byte status;

    /**
     * 活动开始时间
     */
    @NotNull(message = "{activity.beginTime.notnull}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    /**
     * 活动结束时间
     */
    @NotNull(message = "{activity.endTime.notnull}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 逻辑删除字段 0未删除 2已删除
     */
    private Integer delFlag;

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getVoucher() {
        return voucher;
    }

    public void setVoucher(Double voucher) {
        this.voucher = voucher;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

}
