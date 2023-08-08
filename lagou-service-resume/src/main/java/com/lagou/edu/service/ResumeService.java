package com.lagou.edu.service;

import com.lagou.edu.pojo.Resume;

/**
 * ClassName: ResumeService
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-25 下午10:43   @Version 1.0        描述
 */
public interface ResumeService {

    Resume findDefaultResumeByUserId(Long userId);
}
