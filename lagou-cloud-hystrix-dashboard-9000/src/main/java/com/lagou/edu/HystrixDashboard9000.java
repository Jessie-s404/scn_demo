package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * ClassName: HystrixDashboard9000
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-08-06 下午3:50   @Version 1.0        描述
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard //开启Hystrix Dashboard功能
public class HystrixDashboard9000 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9000.class, args);
    }
}

