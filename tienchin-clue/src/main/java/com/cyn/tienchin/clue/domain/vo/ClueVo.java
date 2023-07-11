package com.cyn.tienchin.clue.domain.vo;

import com.cyn.tienchin.common.core.domain.BaseEntity;

/**
 * @author Godc
 * @description:
 * @date 2023/7/11/0011 13:15
 */
public class ClueVo extends BaseEntity {
    private String customerName;
    private Integer status;
    private String phoneNumber;
    private String owner;
    private Integer channelId;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }


    @Override
    public String toString() {
        return "ClueVo{" +
                "customerName='" + customerName + '\'' +
                ", status=" + status +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", channelId=" + channelId +
                '}';
    }
}
