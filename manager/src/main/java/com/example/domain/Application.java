package com.example.domain;

import java.io.Serializable;


public class Application implements Serializable {

    private static final long serialVersionUID = 1L;



    /**
     * a_id
     */
    private Integer aId;

    /**
     * 外键
     */
    private Integer userId;

    /**
     * 外键
     */
    private Integer recruitmentId;

    /**
     * 企业对学生应聘的回复
     */
    private String reply;

    /**
     * 7已投递简历，1企业同意并回复，2企业拒绝，3学生同意，4学生拒绝，5企业已更新面试信息，6已完成
     */
    private Integer aStatus;

    /**
     * 面试时间
     */
    private String interviewTime;

    /**
     * 面试方式
     */
    private String interviewWay;

    /**
     * 面试地点
     */
    private String interviewPlace;

    public Application() {}


    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(Integer recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewWay() {
        return interviewWay;
    }

    public void setInterviewWay(String interviewWay) {
        this.interviewWay = interviewWay;
    }

    public String getInterviewPlace() {
        return interviewPlace;
    }

    public void setInterviewPlace(String interviewPlace) {
        this.interviewPlace = interviewPlace;
    }
}
