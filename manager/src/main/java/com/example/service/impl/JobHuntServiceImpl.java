package com.example.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.JobHunt;
import com.example.dao.JobHuntDao;
import com.example.domain.Recruitment;
import com.example.service.JobHuntService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zby
 * @since 2023-04-17
 */
@Service
public class JobHuntServiceImpl extends ServiceImpl<JobHuntDao, JobHunt> implements JobHuntService {

    @Resource
    private JobHuntDao jobHuntDao;

    @Override
    public List<HashMap> getAll(Integer pageNum, Integer pageSize, String positon,String positionWorkplace,String minSalary) {
        Page<HashMap> page = new Page<>(pageNum, pageSize);
        List<HashMap> all = jobHuntDao.getAll(page,positon,positionWorkplace,minSalary);
        return all;
    }

    @Override
    public List<HashMap> getTotal(Map<String, Object> params) {
        List<HashMap> all = jobHuntDao.getTotl(params);
        return all;
    }
}
