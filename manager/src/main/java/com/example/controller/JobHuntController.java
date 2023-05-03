package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.Result;
import com.example.domain.Complaint;
import com.example.service.JobHuntService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  求职信息controller层
 * </p>
 *
 * @author zby
 * @since 2023-04-17
 */
@RestController
@RequestMapping("/jobhunt")
@CrossOrigin
public class JobHuntController {

    @Resource
    private JobHuntService jobHuntService;

    /**
     * 查看求职者投递信息 -所有
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getPage")
    public List<HashMap> getPage (@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        List<HashMap> all = jobHuntService.getAll(pageNum, pageSize);
        return all;
    }



}

