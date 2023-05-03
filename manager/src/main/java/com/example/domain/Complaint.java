package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 外键关联企业id
     */
    private Integer companyId;

    /**
     * 外键关联用户id
     */
    private Integer userId;

    /**
     * 原因
     */
    private String reason;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date createTime;

    /**
     * 管理端回复
     */
    private String reply;

    /**
     * 投诉受理状态.1未受理，2已受理，3已拒绝。2和3都会有管理端的回复，管理员回复是伴随着受理或者拒绝这两个操作的，企业的回复不改变status字段。
     */
    private int status;

    /**
     * 企业回复.查询到投诉之后 更新企业回复字段
     */
    private String companyReply;

    /**
     * 1.欺诈行为rnrn 2.虚假宣传rnrn 3.不公平待遇rnrn 4.工作条件rn5.工资问题rnrn 6.其他问题
     */
    private int type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCompanyReply() {
        return companyReply;
    }

    public void setCompanyReply(String companyReply) {
        this.companyReply = companyReply;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
