package com.example.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.ApplicationDao;
import com.example.domain.Application;
import com.example.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationDao, Application>  implements ApplicationService {

    @Resource
    private ApplicationDao applicationDao;

    @Override
    public List<HashMap> getAll(int pageNum, int pageSize, String career) {
        Page<HashMap> page = new Page<>(pageNum, pageSize);
        String loginIdAsString = StpUtil.getLoginIdAsString();
        List<HashMap> list = applicationDao.getAll(page,career,loginIdAsString);
        return list;
    }

    @Override
    public List<HashMap> getTotal(String career) {
        String loginIdAsString = StpUtil.getLoginIdAsString();
        List<HashMap> all = applicationDao.getTotl(career,loginIdAsString);
        return all;
    }
}
