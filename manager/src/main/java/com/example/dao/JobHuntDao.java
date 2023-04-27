package com.example.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.JobHunt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zby
 * @since 2023-04-17
 */
@Mapper
public interface JobHuntDao extends BaseMapper<JobHunt> {

    @SelectProvider(type = MyProvider.class, method = "getAllMethod")
    List<HashMap> getAll(Page<HashMap> page);


    class MyProvider{
        public String getAllMethod() {
            return "SELECT\n" +
                    "\tjh.user_id AS userId,\n" +
                    "\ts.NAME AS NAME,\n" +
                    "\ts.age AS age,\n" +
                    "\ts.gender AS gender,\n" +
                    "\ts.hobby AS hobby,\n" +
                    "\ts.university AS university,\n" +
                    "\ts.major AS major,\n" +
                    "\tr.photo AS photo,\n" +
                    "\tr.work_experiene AS workExperiene,\n" +
                    "\tr.self_assessment AS selfAssessment,\n" +
                    "\tr.award AS award,\n" +
                    "\tjh.create_time AS createTime,\n" +
                    "\tjh.min_salary AS minSalary,\n" +
                    "\tjh.position AS position,\n" +
                    "\tjh.job_type AS jobType,\n" +
                    "\tjh.position_workplace AS positionWorkplace,\n" +
                    "\tjh.note AS note \n" +
                    "FROM\n" +
                    "\tjob_hunt jh\n" +
                    "\tJOIN resume r ON jh.user_id = r.user_id\n" +
                    "\tJOIN student s ON jh.user_id = s.user_id \n" +
                    "WHERE\n" +
                    "\tjh.`status` = 1";
        }
    }
}
