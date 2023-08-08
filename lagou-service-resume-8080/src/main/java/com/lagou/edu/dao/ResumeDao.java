package com.lagou.edu.dao;

import com.lagou.edu.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName: ResumeDao
 * Description:
 *
 * @Author: shenjiaqi
 * 编辑于：2023-06-25 下午10:42   @Version 1.0        描述
 */
public interface ResumeDao extends JpaRepository<Resume, Long> {

}
