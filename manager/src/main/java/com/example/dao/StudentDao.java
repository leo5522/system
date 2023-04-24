package com.example.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zby
 * @since 2023-04-15
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {

}
