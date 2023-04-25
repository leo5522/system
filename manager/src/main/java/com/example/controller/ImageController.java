package com.example.controller;

import cn.hutool.json.JSONObject;
import com.example.common.Constants;
import com.example.common.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/images")
@CrossOrigin
public class ImageController {


    @Value("${app.upload.dir}")
    private String uploadDir;

    @Value("${app.upload.urlPrefix}")
    private String urlPrefix;


    @PostMapping("/upload")
    public Result uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            // 获取文件名
            String originalFilename = StringUtils.defaultIfBlank(file.getOriginalFilename(), UUID.randomUUID().toString());
            // 获取文件扩展名
            String extension = FilenameUtils.getExtension(originalFilename);
            // 生成唯一的文件名
            String fileName = UUID.randomUUID().toString() + "." + extension;

            // 保存文件到磁盘
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadDir + File.separator + fileName);
            Files.write(path, bytes);
            JSONObject json = new JSONObject();
            json.set("filename",fileName);
            json.set("url",urlPrefix + fileName);
            // 返回成功响应
            return Result.success(json);

        } catch (IOException e) {
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            return Result.error();
        }
    }

    @DeleteMapping("/files/{fileName}")
    public Result deleteImage(@PathVariable("fileName") String fileName) {
        // 构造文件对象
        File fileToDelete = new File(uploadDir + File.separator + fileName);

        // 判断文件是否存在并且可写
        if (fileToDelete.exists() && fileToDelete.canWrite()) {
            // 删除文件
            if (fileToDelete.delete()) {
                // 返回成功响应
                return Result.success();
            }
        }

        // 文件不存在或删除失败，返回404错误
        return Result.error(Constants.CODE_400,"删除失败");
    }


}
