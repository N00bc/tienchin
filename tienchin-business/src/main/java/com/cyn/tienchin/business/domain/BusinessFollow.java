package com.cyn.tienchin.business.domain;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author Godc
 * @description: 商机跟进
 * @date 2023/7/14/0014 14:14
 */
public class BusinessFollow {
    private Integer businessId;
    private String customerName;
    private String phoneNumber;
    private String occupation;

    private String education;
    private String province;
    private String city;
    private String area;
    private String wechat;

    private Integer age;
    private String qq;
    private Integer gender;
    private Double height;
    private Double weight;
    private String remark;
    private Integer courseId;
    private String reason;
    private Double hours;
    private Double money;
    private String otherIntention;
    private Integer status;
    private LocalDateTime nextTime;
    @NotBlank(message = "{business.info.notblank}")
    private String info;

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

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getOtherIntention() {
        return otherIntention;
    }

    public void setOtherIntention(String otherIntention) {
        this.otherIntention = otherIntention;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "BusinessFollow{" +
                "businessId=" + businessId +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", occupation='" + occupation + '\'' +
                ", education='" + education + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", wechat='" + wechat + '\'' +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                ", remark='" + remark + '\'' +
                ", courseId=" + courseId +
                ", reason='" + reason + '\'' +
                ", hours=" + hours +
                ", money=" + money +
                ", otherIntention='" + otherIntention + '\'' +
                ", status=" + status +
                ", nextTime=" + nextTime +
                ", info='" + info + '\'' +
                '}';
    }
}
