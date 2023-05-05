package com.example.service.impl;

import cn.dev33.satoken.stp.StpUtil;
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
        Page<Complaint> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
        int companyId = StpUtil.getLoginIdAsInt();
        queryWrapper.eq("company_id",companyId);
        queryWrapper.notIn("status",3,4);
        if (null != status){
            queryWrapper.eq("status",status);
        }
        return complaintDao.selectPage(page,queryWrapper);
//        123
    }
}
