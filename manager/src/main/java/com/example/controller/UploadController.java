package com.example.controller;

import com.example.common.Result;
import com.example.service.UploadService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class UploadController {


    @Resource
    private UploadService uploadService;



    @PostMapping("/upload")
    public Result upload(@RequestPart("file") MultipartFile file) {
        String upload = uploadService.upload(file);
        return Result.success(upload);
    }


}
