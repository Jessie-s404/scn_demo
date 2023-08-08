package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * ClassName: HystrixTurbineApplication9001
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-08-06 下午5:30   @Version 1.0        描述
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine //开启Turbine功能
public class HystrixTurbineApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication9001.class, args);
    }
}
