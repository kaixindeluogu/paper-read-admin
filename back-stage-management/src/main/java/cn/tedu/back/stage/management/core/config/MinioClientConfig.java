package cn.tedu.back.stage.management.core.config;

import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author = bianmy
 * DATE = 2023/7/1 13:31
 */
@Configuration
@Slf4j
public class MinioClientConfig {
    @Autowired
    private MinioConfig minioConfig;

    @Bean
    public MinioClient minioClient() {
        log.info("服务器地址{}", minioConfig.getEndpoint());
        return MinioClient.builder()
                .endpoint(minioConfig.getEndpoint())
                .credentials(minioConfig.getAccessKey(), minioConfig.getSecretKey())
                .build();
    }
}