package com.example.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.Result;
import com.example.domain.Company;
import com.example.domain.Register;
import com.example.domain.User;
import com.example.service.CompanyService;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zby
 * @since 2023-04-15
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Resource
    private CompanyService companyService;

    /**
     * 企业登录
     * @return
     */
    @PostMapping("/login")
    public Result login (@RequestBody User user){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        User one = userService.getOne(wrapper);
        if (null == one){
            return Result.error("405","账号密码不正确");
        }
        if (one.getIsActive() == 1){
            return Result.error("405","账号已被停用,请联系管理员");
        }
        String password = one.getPassword();
        String password1 = user.getPassword();
        if (!password1.equals(password)){
            return Result.error("405","账号密码不正确");
        }

        QueryWrapper<Company> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("user_id",one.getId());
        Company one1 = companyService.getOne(wrapper1);
        StpUtil.login(one1.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return Result.success(tokenInfo);

    }


    /**
     * 企业退出登录
     * @return
     */
    @PostMapping("/logout")
    @SaCheckLogin
    public Result logout(){
        StpUtil.logout();
        return Result.success();
    }


    @PostMapping("/register")
    public Result register (@RequestBody Register register){
        String userName = register.getUserName();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",userName);
        User one = userService.getOne(wrapper);
        if (null != one){
            return Result.error("400","用户名已存在");
        }
        if (!register.getPassword().equals(register.getPassword2())){
            return Result.error("400","密码输入不一致");
        }
        User user = new User();
        user.setUsername(register.getUserName());
        user.setIsActive(2);
        user.setPassword(register.getPassword());
        user.setNickname(register.getUserName());
        user.setEmail("");
        user.setPhone("");
        user.setType(2);
        boolean save = userService.save(user);
        if (save){
            QueryWrapper<User> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("username",user.getUsername());
            User one1 = userService.getOne(wrapper1);
            Integer id = one1.getId();
            Company company = new Company();
            company.setUserId(id);
            company.setCompanyName(register.getCompanyName());
            company.setStatus(1);
            boolean save1 = companyService.save(company);
            if (save1){
                return Result.success();
            }

            return Result.error();
        }


        return Result.error();
    }



}
