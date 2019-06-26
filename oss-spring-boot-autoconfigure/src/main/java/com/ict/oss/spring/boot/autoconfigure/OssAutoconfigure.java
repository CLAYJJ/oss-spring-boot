package com.ict.oss.spring.boot.autoconfigure;

import com.aliyun.oss.OSSClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OssProperties.class)
public class OssAutoconfigure {

    @Bean
    @ConditionalOnMissingBean
    public OSSClient ossClient(OssProperties ossProperties) {
        return new OSSClient(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());
    }
}
