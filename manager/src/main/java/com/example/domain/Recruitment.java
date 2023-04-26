package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.example.common.PageEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("recruitment")
public class Recruitment implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 外键
     */
    @TableField(value = "company_id")
    private Integer companyId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 职位名称
     */
    private String career;

    /**
     * 兼职/全职or长期/短期
     */
    private String jobtype;

    /**
     * 最低薪资
     */
    private Double minsalary;

    /**
     * 最高薪资
     */
    private Double maxsalary;

    /**
     * 工作经验
     */
    private String experience;

    /**
     * 学历要求
     */
    private String education;

    /**
     * 工作地点
     */
    private String workplace;

    /**
     * 工作内容
     */
    private String description;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 审核状态
     */
    private Integer status;

    /**
     * 点击次数
     */
    @TableField(value = "click_count")
    private Integer clickCount;

    /**
     * 发布时间
     */
    @TableField(value = "create_time")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date createTime;


}
