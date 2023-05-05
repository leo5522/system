package com.example.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.CompanyRecruitmentVo;
import com.example.common.Constants;
import com.example.common.Result;
import com.example.domain.Company;
import com.example.domain.Recruitment;
import com.example.service.CompanyService;
import com.example.service.impl.RecruitmentServiceImpl;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
public class RecruitmentController {
    @Resource
    private RecruitmentServiceImpl recruitmentService;

    @Resource
    private CompanyService companyService;


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


    /**
     * 发布招聘信息
     */
    @PostMapping("/save")
    public Result save (@RequestBody Recruitment recruitment){
        if (!(null == recruitment.getId())){
            boolean bool = recruitmentService.updateById(recruitment);
            return bool?Result.success():Result.error();
        }
        recruitment.setStatus(1);
        int companyId = StpUtil.getLoginIdAsInt();
        Company byId = companyService.getById(companyId);
        if (byId.getStatus() != 2 ){
            return Result.error("400","企业未认证");
        }

        recruitment.setCompanyId(StpUtil.getLoginIdAsInt());
        recruitment.setCompanyName(byId.getCompanyName());
        boolean bool = recruitmentService.saveOrUpdate(recruitment);
        return bool?Result.success():Result.error();
    }

    /**
     * 下架招聘信息
     */
    @PostMapping("/delete")
    public Result deleteRecruitment(@RequestBody Recruitment recruitment){
        recruitment.setStatus(4);
        boolean bool = recruitmentService.updateById(recruitment);
        return bool?Result.success():Result.error();
    }

    /**
     * 查看招聘信息
     */
    @PostMapping("/getOne")
    public Result getOne (@RequestBody Recruitment recruitment){

        recruitment = recruitmentService.getById(recruitment.getId());
        if (null == recruitment){
            return Result.error(Constants.CODE_400,"查询失败");
        }
        return Result.success(recruitment);
    }

    @GetMapping("/all")
    public IPage<Recruitment> all (@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,@RequestParam("career") String career,@RequestParam("jobtype") String jobtype ){
        Recruitment recruitment = new Recruitment();
        IPage<Recruitment> page = recruitmentService.getRecruitmentServerList(jobtype,career,pageNum, pageSize);
        return page;
    }


}

