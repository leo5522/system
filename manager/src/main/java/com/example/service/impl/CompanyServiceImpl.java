package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.CompanyDao;
import com.example.domain.Company;
import com.example.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zby
 * @since 2023-04-16
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, Company> implements CompanyService {


    @Resource
    private CompanyDao companyDao;


    @Override
    public Company getCompany(Company company) {
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",company.getUserId());
        Company one = companyDao.selectOne(wrapper);
        return one;
    }
}
