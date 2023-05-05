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


    @SelectProvider(type = JobHuntDao.MyProvider.class, method = "getAllMethod")
    List<HashMap> getAll(Page<HashMap> page,String career,String companyId);



    @SelectProvider(type = JobHuntDao.MyProvider1.class, method = "getAllMethod1")
    List<HashMap> getTotl(String career,String companyId);


    class MyProvider{
        public String getAllMethod(String career,String companyId) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT\n" +
                    "\ta.a_id as id,\n" +
                    "\ta.user_id as userId,\n" +
                    "\ta.a_status as 'status',\n" +
                    "\ta.reply as reply,\n" +
                    "\ta.interview_place as interviewPlace,\n" +
                    "\ta.interview_time as interviewTime,\n" +
                    "\ts.name as name,\n" +
                    "\ts.age as age,\n" +
                    "\ts.address as address,\n" +
                    "\ts.major as major,\n" +
                    "\ts.university as university,\n" +
                    "\ts.hobby as hobby,\n" +
                    "\tr.career as career,\n" +
                    "\tr.id as rId");
            sqlBuilder.append("FROM\n" +
                    "\tapplication a\n" +
                    "\tJOIN student s ON a.user_id = s.user_id\n" +
                    "\tJOIN recruitment r ON r.id = a.recruitment_id  ");
            sqlBuilder.append("WHERE\n" +
                    "\ta.a_status in (1,5,3,7) AND r.company_id = #{companyId}");

            if (!career.equals("")) {
                sqlBuilder.append("AND r.company_id = #{career} ");
            }


            return sqlBuilder.toString();

        }
    }


    class MyProvider1{
        public String getAllMethod1(String career,String companyId) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT\n" +
                    "\ta.a_id as id,\n" +
                    "\ta.user_id as userId,\n" +
                    "\ta.a_status as 'status',\n" +
                    "\ta.reply as reply,\n" +
                    "\ta.interview_place as interviewPlace,\n" +
                    "\ta.interview_time as interviewTime,\n" +
                    "\ts.name as name,\n" +
                    "\ts.age as age,\n" +
                    "\ts.address as address,\n" +
                    "\ts.major as major,\n" +
                    "\ts.university as university,\n" +
                    "\ts.hobby as hobby,\n" +
                    "\tr.career as career,\n" +
                    "\tr.id as rId");
            sqlBuilder.append("FROM\n" +
                    "\tapplication a\n" +
                    "\tJOIN student s ON a.user_id = s.user_id\n" +
                    "\tJOIN recruitment r ON r.id = a.recruitment_id  ");
            sqlBuilder.append("WHERE\n" +
                    "\ta.a_status in (1,5,3,7)");

            if (!career.equals("")) {
                sqlBuilder.append("AND r.company_id = #{career} ");
            }


            return sqlBuilder.toString();

        }
    }

}
