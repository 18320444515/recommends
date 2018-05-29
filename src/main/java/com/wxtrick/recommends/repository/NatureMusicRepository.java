package com.wxtrick.recommends.repository;

import com.wxtrick.recommends.entity.NatureMusic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tianyi
 * @date 2018-05-27 09:59
 */
public interface NatureMusicRepository extends JpaRepository<NatureMusic,Integer> {
    public NatureMusic findByName(String name);
    public NatureMusic findById(int id);
}
