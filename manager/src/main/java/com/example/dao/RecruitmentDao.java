package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.CompanyRecruitmentVo;
import com.example.domain.Recruitment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zby
 * @since 2023-04-16
 */
@Mapper
public interface RecruitmentDao extends BaseMapper<Recruitment> {
    /**
     * 查询所有招聘信息
     * @param page
     * @param career
     * @param education
     * @param workplace
     * @return
     */
    @Select("<script>" +
            "select * from recruitment r left join company c on r.company_id = c.id" +
            "<where>" +
            "<if test=\"career != null and career != ''\">" +
            "r.career like CONCAT('%',#{career},'%')" +
            "</if>" +
            "<if test=\"education != null and education != ''\">" +
            "r.education like CONCAT('%',#{education},'%')" +
            "</if>" +
            "<if test=\"workplace != null and workplace != ''\">" +
            "r.workplace like CONCAT('%',#{workplace},'%')" +
            "</if>" +
            "</where>" +
            "</script>")
    List<CompanyRecruitmentVo> selectAllRecruitmentByCondition(Page<CompanyRecruitmentVo> page, @Param("career") String career, @Param("education") String education, @Param("workplace") String workplace);
}
