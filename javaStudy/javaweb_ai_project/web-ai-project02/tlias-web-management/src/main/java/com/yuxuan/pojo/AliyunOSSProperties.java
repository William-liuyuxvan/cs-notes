package com.yuxuan.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName AliyunOSSProperties
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/27 17:43
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {

    private String endpoint;
    private String bucketName;
    private String region;
}
