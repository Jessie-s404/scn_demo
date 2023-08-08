package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: LagouEurekaServerApp8762
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-30 上午10:30   @Version 1.0        描述
 */
@SpringBootApplication
@EnableEurekaServer
public class LagouEurekaServerApp8762 {
    public static void main(String[] args) {
        SpringApplication.run(LagouEurekaServerApp8762.class,args);
    }
}
