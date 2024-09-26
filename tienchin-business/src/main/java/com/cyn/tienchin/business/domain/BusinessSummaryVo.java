package com.cyn.tienchin.business.domain;

/**
 * @author Godc
 * @description:
 * @date 2023/7/14/0014 20:40
 */
public class BusinessSummaryVo extends BusinessSummary {
    private Integer channelId;
    private Integer activityId;
    private Integer age;
    private String qq;
    private String wechat;
    private Integer gender;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "BusinessSummaryVo{" +
                "channelId=" + channelId +
                ", activityId=" + activityId +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", gender=" + gender +
                '}';
    }
}
