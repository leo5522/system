package com.example.service.impl;

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
        List<HashMap> list = applicationDao.getAll(page,career);
        return list;
    }

    @Override
    public List<HashMap> getTotal(String career) {
        List<HashMap> all = applicationDao.getTotl(career);
        return all;
    }
}
