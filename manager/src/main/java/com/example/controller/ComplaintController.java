package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.Result;
import com.example.domain.Complaint;
import com.example.domain.Recruitment;
import com.example.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/complaint")
public class ComplaintController {

    @Resource
    private ComplaintService complaintService;


    /**
     * 查询企业所有申诉
     * @param pageNum
     * @param pageSize
     * @param status
     * @return
     */
    @GetMapping("/getPage")
    public IPage<Complaint>  getPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam(value = "status",required = false) String status){
        IPage<Complaint> list = complaintService.getRecruitmentServerList(status,pageNum,pageSize);
        return list;
    }


    /**
     * 企业回复
     */
    @PostMapping("/reply")
    public Result reply (@RequestBody Complaint complaint){
        Complaint byId = complaintService.getById(complaint.getId());
        byId.setCompanyReply(complaint.getCompanyReply());
        byId.setStatus(2);
        complaintService.updateById(byId);
        return Result.success();
//        123
    }
}
