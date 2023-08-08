package com.lagou.edu.controller.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: ResumeServiceFeignClient
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-08-06 下午6:45   @Version 1.0        描述
 */
@FeignClient(value = "lagou-service-resume")
@RequestMapping("/resume")
public interface ResumeServiceFeignClient {

    @GetMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId);
}
