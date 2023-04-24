package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.CompanyRecruitmentVo;
import com.example.domain.Recruitment;
import com.example.service.impl.RecruitmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zby
 * @since 2023-04-16
 */
@RestController
@RequestMapping("/recruitment")
public class RecruitmentController {
    @Resource
    private RecruitmentServiceImpl recruitmentService;

    @GetMapping("/getall")
    public IPage<CompanyRecruitmentVo> getAllRecruitment(@RequestParam(value = "career",required = false) String career,
                                                @RequestParam(value = "education",required = false) String education,
                                                @RequestParam(value = "workplace",required = false) String workplace,
                                                @RequestParam Integer pageNum,
                                                @RequestParam Integer pageSize){
        Page<CompanyRecruitmentVo> page = new Page<>(pageNum,pageSize);
        Page<CompanyRecruitmentVo> allRecruitmentByCondition = recruitmentService.getAllRecruitmentByCondition(page, career, education, workplace);
        return allRecruitmentByCondition;
    }

    @GetMapping("/getall2")
    public IPage<Recruitment> getAll(@RequestParam(value = "career",required = false) String career,
                                     @RequestParam(value = "education",required = false) String education,
                                     @RequestParam(value = "workplace",required = false) String workplace,
                                     @RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize){
        IPage<Recruitment> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Recruitment> q = new QueryWrapper<>();
        if(!"".equals(career)){
            q.like("career",career);
        }
        if(!"".equals(education)){
            q.like("education",education);
        }
        if(!"".equals(workplace)){
            q.like("workplace",workplace);
        }
        IPage<Recruitment> page1 = recruitmentService.page(page, q);
        return page1;
    }

}

