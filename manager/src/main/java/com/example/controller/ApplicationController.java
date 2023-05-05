package com.example.controller;

import cn.hutool.json.JSONObject;
import com.example.common.Result;
import com.example.domain.Application;
import com.example.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {


    @Resource
    private ApplicationService applicationService;
    /**
     * 简历库 status in 1,3,5,7
     */

    @GetMapping(value = "/getPage",produces = "application/json;charset=UTF-8")
    public JSONObject getPage (@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
                               @RequestParam(value = "career",required = false) String career){

        List<HashMap> all = applicationService.getAll(pageNum, pageSize,career);
        List<HashMap> total = applicationService.getTotal(career);
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("total",total.size());
        jsonObject.set("data",all);
        return jsonObject;

    }

    /**
     * 企业同意 1
     * @param application
     * @return
     */
    @PostMapping("/agree")
    public Result agree(@RequestBody Application application){
        Application app = applicationService.getById(application.getaId());
        app.setaStatus(1);
        app.setReply(application.getReply());
        applicationService.updateById(app);
        return Result.success();
    }


    /**
     * 企业拒绝 2
     * @param application
     * @return
     */
    @PostMapping("/refuse")
    public Result refuse(@RequestBody Application application){
        Application app = applicationService.getById(application.getaId());
        app.setaStatus(2);
        applicationService.updateById(app);
        return Result.success();
    }



    /**
     * 约定面试 5
     * @param application
     * @return
     */
    @PostMapping("/appointment")
    public Result appointment(@RequestBody Application application){
        Application app = applicationService.getById(application.getaId());
        app.setaStatus(5);
        app.setInterviewPlace(application.getInterviewPlace());
        app.setInterviewTime(application.getInterviewTime());
        app.setInterviewWay(application.getInterviewWay());
        applicationService.updateById(app);
        return Result.success();
    }




}
