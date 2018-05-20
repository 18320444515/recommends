package com.wxtrick.recommends.repository;

import com.wxtrick.recommends.entity.AboutMsg;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tianyi
 * @date 2018-04-29 02:14
 */
public interface AboutMsgRepository extends JpaRepository<AboutMsg,Integer>{
    public AboutMsg findFirstById(Integer id);
}
