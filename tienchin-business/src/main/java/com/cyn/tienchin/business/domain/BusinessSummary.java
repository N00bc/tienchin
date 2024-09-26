package com.cyn.tienchin.business.domain;

import java.time.LocalDateTime;

/**
 * @author Godc
 * @description:
 * @date 2023/7/12/0012 0:28
 */
public class BusinessSummary {
    private Integer businessId;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 客户手机号
     */
    private String phoneNumber;
    /**
     * 跟进人
     */
    private String owner;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 商机状态
     */
    private Integer status;
    /**
     * 下次跟进时间
     */
    private LocalDateTime nextTime;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getNextTime() {
        return nextTime;
    }

    public void setNextTime(LocalDateTime nextTime) {
        this.nextTime = nextTime;
    }

    @Override
    public String toString() {
        return "BusinessSummary{" +
                "businessId=" + businessId +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", nextTime=" + nextTime +
                '}';
    }
}
