package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ApplicationDao extends BaseMapper<Application> {


    @SelectProvider(type = ApplicationDao.MyProvider.class, method = "getAllMethod")
    List<HashMap> getAll(Page<HashMap> page,String career,String companyId);



    @SelectProvider(type = ApplicationDao.MyProvider1.class, method = "getAllMethod1")
    List<HashMap> getTotl(String career,String companyId);


    class MyProvider{
        public String getAllMethod(String career,String companyId) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT a.a_id as id, a.user_id as userId,a.a_status as sta,a.reply as reply,a.interview_place as interviewPlace,a.interview_time as interviewTime,s.name as name,s.age as age,s.address as address,s.major as major,s.university as university,s.hobby as hobby,r.career as career,r.id as rId");
            sqlBuilder.append(" FROM application a JOIN student s ON a.user_id = s.user_id JOIN recruitment r ON a.recruitment_id = r.id ");
            sqlBuilder.append(" WHERE a.a_status in (1,5,3,7) AND r.company_id = #{companyId}");

            if (!career.equals("")) {
                sqlBuilder.append(" AND r.company_id = #{career}");
            }

            return sqlBuilder.toString();

        }
    }


    class MyProvider1{
        public String getAllMethod1(String career,String companyId) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT a.a_id as id, a.user_id as userId,a.a_status as sta,a.reply as reply,a.interview_place as interviewPlace,a.interview_time as interviewTime,s.name as name,s.age as age,s.address as address,s.major as major,s.university as university,s.hobby as hobby,r.career as career,r.id as rId");
            sqlBuilder.append(" FROM application a JOIN student s ON a.user_id = s.user_id JOIN recruitment r ON a.recruitment_id = r.id ");
            sqlBuilder.append(" WHERE a.a_status in (1,5,3,7) AND r.company_id = #{companyId}");

            if (!career.equals("")) {
                sqlBuilder.append(" AND r.company_id = #{career}");
            }

            return sqlBuilder.toString();

        }
    }

}
