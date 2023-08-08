package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: AutodeliverApplication8096
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-08-06 下午6:23   @Version 1.0        描述
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Feign客户端
public class AutodeliverApplication8096 {
    public static void main(String[] args) {
        SpringApplication.run(AutodeliverApplication8096.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
