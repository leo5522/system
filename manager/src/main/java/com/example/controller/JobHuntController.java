package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.Result;
import com.example.domain.Complaint;
import com.example.service.JobHuntService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<HashMap> getPage (@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
                                  @RequestParam(value = "minSalary",required = false) String minSalary,
                                  @RequestParam(value = "position",required = false) String position,
                                  @RequestParam(value = "positionWorkplace",required = false) String positionWorkplace){
        Map<String, Object> params = new HashMap<>();
        params.put("positionWorkplace",positionWorkplace);
        params.put("position",position);
        params.put("minSalary",minSalary);
        List<HashMap> all = jobHuntService.getAll(pageNum, pageSize,params);
        return all;
    }



}

