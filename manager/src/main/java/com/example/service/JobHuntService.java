package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.JobHunt;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zby
 * @since 2023-04-17
 */
public interface JobHuntService extends IService<JobHunt> {

    List<HashMap> getAll(Integer pageNum, Integer pageSize);

}
