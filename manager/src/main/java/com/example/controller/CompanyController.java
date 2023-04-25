package com.example.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Constants;
import com.example.common.Result;
import com.example.domain.Company;
import com.example.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zby
 * @since 2023-04-16
 */
@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {


    @Resource
    private CompanyService companyService;


    /**
     * 根据userid 查询用户下企业
     * @param company
     * @return
     */
    @PostMapping("/getCompany")
    public Result getCompany(Company company){
        // 登录页面完成后删除
        company.setUserId(31);
        Company one = companyService.getCompany(company);
        return Result.success(one);
    }


    /**
     * 企业认证
     * @param company
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Company company){
        // 登录页面完成后删除
        company.setUserId(31);
        Company byId = companyService.getById(company.getUserId());
        if (byId.getStatus() == 0){
            return Result.error(Constants.CODE_400,"企业正在审核中");
        }
        company.setStatus(0);
        boolean bool = companyService.save(company);
        return bool?Result.success():Result.error();
    }



}

