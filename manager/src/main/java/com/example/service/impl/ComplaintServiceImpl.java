package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.ComplaintDao;
import com.example.domain.Complaint;
import com.example.domain.Recruitment;
import com.example.service.ComplaintService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintDao, Complaint> implements ComplaintService {

    @Resource
    private ComplaintDao complaintDao;
    @Override
    public IPage<Complaint> getRecruitmentServerList(String status, int pageNum, int pageSize) {
        // TODO: 企业id修改
        Page<Complaint> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_id",1);
        queryWrapper.eq("status",1);
        if (!"".equals(status)){
            queryWrapper.eq("status",status);
        }
        return complaintDao.selectPage(page,queryWrapper);
    }
}
