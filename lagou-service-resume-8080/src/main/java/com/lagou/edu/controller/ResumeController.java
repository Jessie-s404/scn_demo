package com.lagou.edu.controller;

import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ResumeController
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-07-30 下午5:11   @Version 1.0        描述
 */
@RestController
@RequestMapping("resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Value("${server.port}")
    private Integer port;

    //"/resume/openstate/1545132"
    @RequestMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        return resumeService.findDefaultResumeByUserId(userId).getIsOpenResume();
        return port;
    }
}
