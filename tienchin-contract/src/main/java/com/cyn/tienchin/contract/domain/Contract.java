package com.cyn.tienchin.contract.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 合同实体
 * </p>
 *
 * @author cyn
 * @since 2023-07-15
 */
@TableName("tienchin_contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 合同编号
     */
    @TableId(value = "contract_id", type = IdType.AUTO)
    private Integer contractId;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 客户名
     */
    private String customerName;

    /**
     * 课程分类
     */
    private Integer type;

    /**
     * 活动分类
     */
    private Integer activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道Id
     */
    private Integer channelId;

    /**
     * 合同状态 1=待审核,2=已通过,3=驳回
     */
    private Integer status;

    /**
     * 合同文件地址
     */
    private String filePath;

    /**
     * 合同价
     */
    private BigDecimal contractPrice;

    /**
     * 课程价
     */
    private BigDecimal coursePrice;

    /**
     * 折扣类型1=折扣券,2=代金券
     */
    private Integer discountType;

    /**
     * 对应flowable实例id
     */
    private String processInstanceId;

    /**
     * 商机id
     */
    private Integer businessId;

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
     * 审批人名称
     */
    private String approveUserName;
    /**
     * 审批部门名称
     */
    private String approveDeptName;
    /**
     * 审批用户id
     */
    private Integer approveUserId;
    /**
     * 审批部门id
     */
    private Integer approveDeptId;
    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Integer delFlag;

    /**
     * 备注
     */
    private String remark;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public BigDecimal getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(BigDecimal coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApproveUserName() {
        return approveUserName;
    }

    public void setApproveUserName(String approveUserName) {
        this.approveUserName = approveUserName;
    }

    public String getApproveDeptName() {
        return approveDeptName;
    }

    public void setApproveDeptName(String approveDeptName) {
        this.approveDeptName = approveDeptName;
    }

    public Integer getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(Integer approveUserId) {
        this.approveUserId = approveUserId;
    }

    public Integer getApproveDeptId() {
        return approveDeptId;
    }

    public void setApproveDeptId(Integer approveDeptId) {
        this.approveDeptId = approveDeptId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", type='" + type + '\'' +
                ", activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", channelName='" + channelName + '\'' +
                ", channelId=" + channelId +
                ", status=" + status +
                ", filePath='" + filePath + '\'' +
                ", contractPrice=" + contractPrice +
                ", coursePrice=" + coursePrice +
                ", discountType=" + discountType +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", businessId=" + businessId +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", approveUserName='" + approveUserName + '\'' +
                ", approveDeptName='" + approveDeptName + '\'' +
                ", approveUserId=" + approveUserId +
                ", approveDeptId=" + approveDeptId +
                ", delFlag=" + delFlag +
                ", remark='" + remark + '\'' +
                '}';
    }
}
