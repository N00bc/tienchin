package com.cyn.tienchin.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cyn
 * @since 2023-07-11
 */
@TableName("tienchin_business")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 线索id
     */
    @TableId(value = "business_id", type = IdType.AUTO)
    private Integer businessId;

    /**
     * 客户名
     */
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
    private Boolean gender;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 年龄
     */
    private Boolean age;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * qq号
     */
    private Integer qq;

    /**
     * 意向等级 1~4 由强到弱
     */
    private Boolean level;

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
    private Boolean failCount;

    /**
     * 下次跟进时间
     */
    private LocalDateTime nextTime;

    /**
     * 线索失效时间，DDL
     */
    private LocalDateTime endTime;

    /**
     * 是否需要转派 1=需要,0=不需要
     */
    private Boolean transfer;

    /**
     * 备注
     */
    private String remark;

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
     * 是否删除 0=未删除,2=已删除
     */
    private Boolean delFlag;

    /**
     * 省份
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 学历
     */
    private String education;

    /**
     * 体重kg
     */
    private Object weight;

    /**
     * 身高m
     */
    private Object height;

    /**
     * 每周锻炼时间
     */
    private Object hours;

    /**
     * 其他意向
     */
    private String otherIntention;

    /**
     * 线索Id
     */
    private Integer clueId;

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getAge() {
        return age;
    }

    public void setAge(Boolean age) {
        this.age = age;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
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

    public Boolean getFailCount() {
        return failCount;
    }

    public void setFailCount(Boolean failCount) {
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

    public Boolean getTransfer() {
        return transfer;
    }

    public void setTransfer(Boolean transfer) {
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

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public Object getHours() {
        return hours;
    }

    public void setHours(Object hours) {
        this.hours = hours;
    }

    public String getOtherIntention() {
        return otherIntention;
    }

    public void setOtherIntention(String otherIntention) {
        this.otherIntention = otherIntention;
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    @Override
    public String toString() {
        return "Business{" +
            "businessId = " + businessId +
            ", customerName = " + customerName +
            ", channelId = " + channelId +
            ", activityId = " + activityId +
            ", gender = " + gender +
            ", phoneNumber = " + phoneNumber +
            ", age = " + age +
            ", wechat = " + wechat +
            ", qq = " + qq +
            ", level = " + level +
            ", subject = " + subject +
            ", status = " + status +
            ", failCount = " + failCount +
            ", nextTime = " + nextTime +
            ", endTime = " + endTime +
            ", transfer = " + transfer +
            ", remark = " + remark +
            ", createBy = " + createBy +
            ", updateBy = " + updateBy +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", delFlag = " + delFlag +
            ", province = " + province +
            ", city = " + city +
            ", area = " + area +
            ", courseId = " + courseId +
            ", occupation = " + occupation +
            ", education = " + education +
            ", weight = " + weight +
            ", height = " + height +
            ", hours = " + hours +
            ", otherIntention = " + otherIntention +
            ", clueId = " + clueId +
        "}";
    }
}
