package com.cyn.tienchin.clue.domain.vo;

import java.time.LocalDateTime;

/**
 * @author Godc
 * @description: ClueDetails 组件中展示的数据
 * @date 2023/7/09/0009 21:08
 */
public class ClueDetails {

    private Integer clueId;

    /**
     * 客户名
     */
    private String customerName;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 性别 0=男,1=女,2=未知
     */
    private Integer gender;

    /**
     * 手机号码
     */
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
    private LocalDateTime nextTime;
    /**
     * 线索分配人,即tienchin_assign的create_by字段
     */
    private String allocator;
    /**
     * 活动信息
     */
    private String activityInfo;
    /**
     * 线索所属人
     */
    private String owner;
    /**
     * 分配时间
     */
    private LocalDateTime belongTime;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getAllocator() {
        return allocator;
    }

    public void setAllocator(String allocator) {
        this.allocator = allocator;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getBelongTime() {
        return belongTime;
    }

    public void setBelongTime(LocalDateTime belongTime) {
        this.belongTime = belongTime;
    }

    @Override
    public String toString() {
        return "ClueDetails{" +
                "clueId=" + clueId +
                ", customerName='" + customerName + '\'' +
                ", channelName='" + channelName + '\'' +
                ", activityName='" + activityName + '\'' +
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
                ", allocator='" + allocator + '\'' +
                ", activityInfo='" + activityInfo + '\'' +
                ", owner='" + owner + '\'' +
                ", belongTime=" + belongTime +
                ", createTime=" + createTime +
                '}';
    }
}
