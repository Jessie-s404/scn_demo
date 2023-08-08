package com.lagou.edu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ClassName: AutodeliverController
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-28 下午10:49   @Version 1.0        描述
 */
@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {

    @Autowired
    private RestTemplate restTemplate;

//    @GetMapping("/checkState/{userId}")
//    public Integer findResumeOpenState(@PathVariable Long userId) {
//        // 调用远程服务->简历微服务接口 RestTemplate
//        // httpclient封装好多内容进行远程调用
//        Integer forObject = restTemplate.getForObject("http://localhost:8080/resume/openstate/" + userId, Integer.class);
//        return forObject;
//    }

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 服务注册到Eureka之后的改造
     * @param userId
     * @return
     */
//    @GetMapping("/checkState/{userId}")
//    public Integer findResumeOpenState(@PathVariable Long userId) {
//        //TODO 从Eureka Server中获取我们关注的那个服务的实例信息以及接口信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("lagou-service-resume");
//        ServiceInstance serviceInstance = instances.get(0);
//
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//
//        String url = "http://" + host + ":" + port + "/resume/openstate/" + userId;
//        System.out.println("==============>>>从Eureka Server中获取的服务地址：" + url);
//        // 调用远程服务->简历微服务接口 RestTemplate
//        // httpclient封装好多内容进行远程调用
//        Integer forObject = restTemplate.getForObject(url, Integer.class);
//        return forObject;
//    }

    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        String url = "http://lagou-service-resume/resume/openstate/" + userId;
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        return forObject;
    }

    /**
     * 提供者模拟处理超时，调用方法添加Hystrix控制
     * @param userId
     * @return
     */
    //使用@HystrixCommand注解进行熔断控制
    @HystrixCommand(
            threadPoolKey = "findResumeOpenStateTimeout",//线程池名称，要保持唯一，相同的名称使用同一个线程池
            threadPoolProperties = {
                    // 线程池大小
                    @HystrixProperty(name = "coreSize", value = "1"),
                    // 线程等待队列长度
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
                    // 线程存活时间
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),
                    // 队列拒绝阈值 超过10个之后，就需要走拒绝策略
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "10"),
                    // 超时时间
                    @HystrixProperty(name = "timeoutInMilliseconds", value = "2000")
            },
            commandProperties = {
                    // 每一个属性都是HystrixCommandProperties中的一个实例
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000"),//超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),//请求次数
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),//失败率达到多少后跳闸
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000"),//跳闸后多久开始尝试恢复
            }
    )

    @GetMapping("/checkStateTimeout/{userId}")
    public Integer findResumeOpenStateTimeout(@PathVariable Long userId) {
        //使用ribbon不需要我们自己获取服务实例然后选择一个那么去访问了（自己的负载均衡）
        String url = "http://lagou-service-resume/resume/openstate/" + userId;//指定服务名
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        return forObject;
    }

    @HystrixCommand(
            commandProperties = {
                    // 每一个属性都是HystrixCommandProperties中的一个实例
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            },fallbackMethod = "myFallback"//回退方法
    )
    @GetMapping("/checkStateTimeoutFallback/{userId}")
    public Integer findResumeOpenStateTimeoutFallback(@PathVariable Long userId) {
        String url = "http://lagou-service-resume/resume/openstate/" + userId;
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        return forObject;
    }

    public Integer myFallback(Long userId){
        return -1;//兜底数据
    }
}
