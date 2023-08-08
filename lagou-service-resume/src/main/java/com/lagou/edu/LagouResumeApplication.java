package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName: LagouResumeApplication
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-25 下午10:56   @Version 1.0        描述
 */
@SpringBootApplication
@EntityScan("com.lagou.edu.pojo")
//@EnableEurekaClient //开启Rureka Client(Eureka独有)
@EnableDiscoveryClient //开启注册中心客户端 （通用型注解，比如注册到Eureka、Nacos等）
public class LagouResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagouResumeApplication.class, args);
    }
}
