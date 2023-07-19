package com.cyn.tienchin.contract.domain;

import java.math.BigDecimal;

/**
 * @author Godc
 * @description: 首页展示摘要信息
 * @date 2023/7/16/0016 22:34
 */
public class ContractSummary {
    /**
     * 合同id
     */
    private Integer contractId;
    /**
     * 任务id
     */
    private String taskId;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 客户名
     */
    private String customerName;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 合同价格
     */
    private BigDecimal contractPrice;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 文件存储路径
     */
    private String filePath;
    /**
     * 拒绝或同意理由
     */
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public String toString() {
        return "ContractSummary{" +
                "contractId=" + contractId +
                ", taskId='" + taskId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", contractPrice=" + contractPrice +
                ", activityName='" + activityName + '\'' +
                ", channelName='" + channelName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
