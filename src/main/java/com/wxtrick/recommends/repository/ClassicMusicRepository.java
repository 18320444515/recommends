package com.wxtrick.recommends.repository;

import com.wxtrick.recommends.entity.ClassicMusic;
import com.wxtrick.recommends.entity.NatureMusic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tianyi
 * @date 2018-05-27 09:59
 */
public interface ClassicMusicRepository extends JpaRepository<ClassicMusic,Integer> {
    public ClassicMusic findByName(String name);
    public ClassicMusic findById(int id);
}
