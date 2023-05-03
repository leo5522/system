package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Complaint;
import com.example.domain.Recruitment;

public interface ComplaintService extends IService<Complaint> {


    IPage<Complaint> getRecruitmentServerList(String status, int pageNum, int pageSize);
}
