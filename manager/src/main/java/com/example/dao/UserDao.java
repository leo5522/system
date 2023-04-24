package com.example.dao;

import com.example.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UserDao extends BaseMapper<User> {

}
