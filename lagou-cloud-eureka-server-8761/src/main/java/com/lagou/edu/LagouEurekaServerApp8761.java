package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: LagouEurekaServerApp8761
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-30 上午12:01   @Version 1.0        描述
 */
@SpringBootApplication
@EnableEurekaServer
public class LagouEurekaServerApp8761 {
    public static void main(String[] args) {
        SpringApplication.run(LagouEurekaServerApp8761.class, args);
    }
}
