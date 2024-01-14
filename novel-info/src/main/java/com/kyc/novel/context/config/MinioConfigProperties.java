package com.kyc.novel.context.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioConfigProperties {

    private String endpoint;
    private String accessKey;
    private String secretKey;

    @PostConstruct
    public void init() {
        System.out.println("=======================================================================minio服务地址：" + endpoint);
    }
}
