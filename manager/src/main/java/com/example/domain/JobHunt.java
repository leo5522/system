package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zby
 * @since 2023-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("job_hunt")
public class JobHunt implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 外键
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 意向岗位
     */
    private String position;

    /**
     * 0全职/1兼职
     */
    @TableField(value = "job_type")
    private Integer jobType;

    /**
     * 最低薪资
     */
    @TableField(value = "min_salary")
    private Double minSalary;

    /**
     * 意向工作地点
     */
    @TableField(value = "position_workplace")
    private String positionWorkplace;

    /**
     * 点击量
     */
    @TableField(value = "click_count")
    private Integer clickCount;

    /**
     * 备注
     */
    private String note;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private String createTime;

    /**
     * 最终选择的公司
     */
    @TableField(value = "final_company")
    private String finalCompany;
    /**
     * 求职信息的状态
     */
    private Integer status;
}
