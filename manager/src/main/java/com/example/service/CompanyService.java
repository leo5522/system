package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Company;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zby
 * @since 2023-04-16
 */
public interface CompanyService extends IService<Company> {


    /**
     * 根据userid 查询用户下企业
     * @return
     */
    Company getCompany(Company company);
}
