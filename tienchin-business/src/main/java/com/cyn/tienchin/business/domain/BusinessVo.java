package com.cyn.tienchin.business.domain;

import com.cyn.tienchin.common.core.domain.BaseEntity;

/**
 * @author Godc
 * @description:
 * @date 2023/7/14/0014 22:20
 */
public class BusinessVo extends BaseEntity {
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
     * 商机状态
     */
    private Integer status;
    /**
     * 渠道Id
     */
    private Integer channelId;


    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "BusinessVo{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", status=" + status +
                ", channelId=" + channelId +
                '}';
    }
}
