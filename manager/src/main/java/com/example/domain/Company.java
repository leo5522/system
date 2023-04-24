package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.example.common.PageEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zby
 * @since 2023-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("company")
public class Company  extends PageEntity implements Serializable  {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 外键
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 企业类型
     */
    @TableField(value = "company_type")
    private String companyType;

    /**
     * 企业名称
     */
    @TableField(value = "company_name")
    private String companyName;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 企业LOGO
     */
    private String logo;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 法定代表人
     */
    private String legalperson;

    /**
     * 联系电话
     */
    @TableField(value = "company_phone")
    private String companyPhone;

    /**
     * 成立日期
     */
    @TableField(value = "establish_date")
    private String establishDate;

    /**
     * 企业邮箱
     */
    @TableField(value = "company_email")
    private String companyEmail;

    /**
     * 注册资本
     */
    private String capital;

    /**
     * 实缴资本
     */
    @TableField
    private String paidIn;

    /**
     * 营业执照
     */
    private String license;

    /**
     * 统一社会信用代码
     */
    private String uscc;

    /**
     * 参保人数
     */
    private String insured;

    /**
     * 营业期限
     */
    private String duration;

    /**
     * 登记机关
     */
    private String authority;

    /**
     * 人员规模
     */
    @TableField(value = "staff_size")
    private String staffSize;

    /**
     * 工商注册号
     */
    private String number;

    /**
     * 组织机构代码
     */
    private String code;

    /**
     * 核准日期
     */
    @TableField(value = "approval_date")
    private String approvalDate;

    /**
     * 认证状态
     */
    private Integer status;
    /**
     * 企业评分
     */
    private Integer score;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;


}
