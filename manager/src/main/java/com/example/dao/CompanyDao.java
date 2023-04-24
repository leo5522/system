package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Company;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zby
 * @since 2023-04-16
 */
@Mapper
public interface CompanyDao extends BaseMapper<Company> {

}
