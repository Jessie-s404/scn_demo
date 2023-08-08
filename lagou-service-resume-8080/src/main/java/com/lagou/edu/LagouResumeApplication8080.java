package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: LagouResumeApplication8080
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-30 上午11:05   @Version 1.0        描述
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LagouResumeApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(LagouResumeApplication8080.class, args);
    }
}
