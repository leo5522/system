package com.example.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.CompanyRecruitmentVo;
import com.example.domain.Recruitment;
import com.example.dao.RecruitmentDao;
import com.example.service.IRecruitmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
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
public class RecruitmentServiceImpl extends ServiceImpl<RecruitmentDao, Recruitment> implements IRecruitmentService {
    @Resource
    private RecruitmentDao recruitmentDao;

    /**
     * 模糊查询
     * 查询出来所有的招聘信息
     * @param page
     * @param career
     * @param education
     * @param workplace
     * @return
     */
    public Page<CompanyRecruitmentVo> getAllRecruitmentByCondition(Page<CompanyRecruitmentVo> page, String career, String education, String workplace){
        String loginIdAsString = StpUtil.getLoginIdAsString();
        return page.setRecords(recruitmentDao.selectAllRecruitmentByCondition(page,career,education,workplace,loginIdAsString));
    }

    @Override
    public IPage<Recruitment> getRecruitmentServerList(String jobtype,String career, Integer pageNum, Integer pageSize) {
        Page<Recruitment> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Recruitment> queryWrapper = new QueryWrapper<>();
        int companyId = StpUtil.getLoginIdAsInt();
        queryWrapper.eq("company_id",companyId);
        if(!jobtype.equals("") || jobtype == null){
            queryWrapper.like("jobtype",jobtype);
        }
        if (!career.equals("") || career == null){
            queryWrapper.like("career",career);
        }
        return recruitmentDao.selectPage(page,queryWrapper);
    }
}
