package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Recruitment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zby
 * @since 2023-04-16
 */
public interface IRecruitmentService extends IService<Recruitment> {

    /**
     * 分页查询招聘信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<Recruitment> getRecruitmentServerList(Integer userId,Integer pageNum, Integer pageSize);
}
