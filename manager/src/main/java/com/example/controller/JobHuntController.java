package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.Result;
import com.example.domain.Complaint;
import com.example.service.JobHuntService;
import org.json.JSONException;
import org.json.JSONObject;
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
    @GetMapping(value = "/getPage",produces = "application/json;charset=UTF-8")
    public String  getPage (@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
                                  @RequestParam(value = "minSalary",required = false) String minSalary,
                                  @RequestParam(value = "position",required = false) String position,
                                  @RequestParam(value = "positionWorkplace",required = false) String positionWorkplace) throws JSONException {
        Map<String, Object> params = new HashMap<>();
        params.put("positionWorkplace",positionWorkplace);
        params.put("position",position);
        params.put("minSalary",minSalary);
        List<HashMap> all = jobHuntService.getAll(pageNum, pageSize,params);
        List<HashMap> total = jobHuntService.getTotal(params);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",total.size());
        jsonObject.put("data",all);
        return jsonObject.toString();
    }



}

