package com.spring.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;


@Component
public class AliOSSUtils {
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId;
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret;
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;

    @Autowired
    private AliOSSProperties aliOSSProperties;

    public String upload(MultipartFile file) throws Exception {

        String endpoint =aliOSSProperties.getEndpoint();
        String accessKeyId=aliOSSProperties.getAccessKeyId();
        String accessKeySecret=aliOSSProperties.getAccessKeySecret();
        String bucketName=aliOSSProperties.getBucketName();

        InputStream inputStream = file.getInputStream();

        String oroginalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + oroginalFilename.substring(oroginalFilename.lastIndexOf("."));

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, fileName, inputStream);

        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        ossClient.shutdown();
        return url;
    }
}