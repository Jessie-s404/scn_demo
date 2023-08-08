package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: LagouResumeApplication8081
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-30 下午4:19   @Version 1.0        描述
 */
@SpringBootApplication
@EntityScan("com.lagou.edu.pojo")
@EnableDiscoveryClient
public class LagouResumeApplication8081 {
    public static void main(String[] args) {
        SpringApplication.run(LagouResumeApplication8081.class, args);
    }
}
