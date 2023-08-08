package com.lagou.edu;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: AutodeliverApplication
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-28 下午10:53   @Version 1.0        描述
 */
@SpringBootApplication
@EnableDiscoveryClient //开启注册中心客户端 （通用型注解，比如注册到Eureka、Nacos等）
//@EnableHystrix //打开Hystrix断路器
@EnableCircuitBreaker //开启熔断器功能
//@SpringCloudApplication //组合注解，相当于@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker三个注解的组合
public class AutodeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutodeliverApplication.class, args);
    }

    //使用RestTemplate模板对象进行远程调用
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 在被监控的微服务中注册一个Servlet，后期我们就是访问这个Servlet来获取该服务的Hystrix监控数据
     * 前提：被监控的微服务需要引入spring-boot-starter-actuator依赖
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet, "/hystrix.stream");
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
