package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Application;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface ApplicationService extends IService<Application> {


    List<HashMap> getAll(int pageNum, int pageSize, String career);

    List<HashMap> getTotal(String career);
}
