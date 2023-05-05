package com.example.service;

import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSSClient;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;

public class UploadService {

    private static final int MAX_RETRY_TIMES = 3; // 最大重试次数
    @Resource
    private OSSClient ossClient;

    @Resource
    private Environment env;



    /**
     * 用户头像上传
     * @param file：头像
     * @return 图片Url
     */

    public String upload(MultipartFile file) {
        //1、创建oss客户端连接
        String url = null;
        try {
            //2、获取文件输入流
            InputStream inputStream = file.getInputStream();
            //3、获取原始文件名
            String originFileName = file.getOriginalFilename();
            //4、防止文件重名
            String uuidFileName = cn.hutool.core.lang.UUID.randomUUID().toString(true) + originFileName;
            //4.1、精确到日
            String dateTime = DateTime.now().toString("yyyy-MM-dd");
            //5、拼接文件名
            String realFileName = dateTime + uuidFileName ;
            //拼接dir根目录
            String dirFileName = env.getProperty("aliyun.oss.dir.prefix") + realFileName;



            //6、创建oss请求，传入三个参数
            ossClient.putObject(env.getProperty("aliyun.oss.bucketName"),dirFileName, inputStream);

            //7、拼接图片url路径，方便后续入库
//            url = "https://" + env.getProperty("aliyun.oss.bucketName")+ "." + env.getProperty("aliyun.oss.endpoint") + "/" + dirFileName;
            url = "https://" + env.getProperty("aliyun.oss.bucketName")+ "."
                    + env.getProperty("aliyun.oss.endpoint") + "/" + dirFileName;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭client连接
//            ossClient.shutdown();
        }
        return url;

    }





}
