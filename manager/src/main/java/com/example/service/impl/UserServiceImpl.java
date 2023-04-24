package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zby
 * @since 2023-04-15
 */
//添加和新增
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
