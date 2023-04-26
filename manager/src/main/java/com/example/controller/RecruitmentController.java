package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.CompanyRecruitmentVo;
import com.example.common.Constants;
import com.example.common.Result;
import com.example.domain.Recruitment;
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
        //TODO：替换company_id
        recruitment.setCompanyId(2);
        recruitment.setCompanyName("1229 company");
        boolean bool = recruitmentService.save(recruitment);
        return bool?Result.success():Result.error();
    }

    /**
     * 删除招聘信息
     */
    @PostMapping
    public Result deleteRecruitment(@RequestBody Recruitment recruitment){
        recruitment.setStatus(4);
        boolean bool = recruitmentService.updateById(recruitment);
        return bool?Result.success():Result.error();
    }

    /**
     * 查看招聘信息
     */
    @GetMapping("/getOne")
    public Result getOne (@RequestBody Recruitment recruitment){

        recruitment = recruitmentService.getById(15);
        if (null == recruitment){
            return Result.error(Constants.CODE_400,"查询失败");
        }
        return Result.success(recruitment);
    }

    @GetMapping("/all")
    public IPage<Recruitment> all (@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,@RequestParam("career") String career,@RequestParam("jobtype") String jobtype ){
        //TODO：替换company_id
        Recruitment recruitment = new Recruitment();
        IPage<Recruitment> page = recruitmentService.getRecruitmentServerList(jobtype,career,pageNum, pageSize);
        return page;
    }


}

