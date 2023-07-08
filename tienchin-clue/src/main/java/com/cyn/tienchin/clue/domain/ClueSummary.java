package com.cyn.tienchin.clue.domain;

import java.time.LocalDateTime;

/**
 * @author Godc
 * @description:
 * @date 2023/7/07/0007 22:32
 */
public class ClueSummary {
    /**
     * 线索id
     */
    private Integer clueId;

    /**
     * 客户名
     */
    private String customerName;

    /**
     * 渠道名
     */
    private String channelName;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 线索状态:1=已分配,2=跟进中,3=已回收,4=伪线索
     */
    private Integer status;

    /**
     * 线索拥有人
     */
    private String owner;

    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 下次跟进时间
     */
    private LocalDateTime nextTime;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getNextTime() {
        return nextTime;
    }

    public void setNextTime(LocalDateTime nextTime) {
        this.nextTime = nextTime;
    }

    @Override
    public String toString() {
        return "ClueSummary{" +
                "clueId=" + clueId +
                ", customerName='" + customerName + '\'' +
                ", channelName='" + channelName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                ", owner='" + owner + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", nextTime=" + nextTime +
                '}';
    }
}
