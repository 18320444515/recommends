package com.wxtrick.recommends.repository;

import com.wxtrick.recommends.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tianyi
 * @date 2018-04-29 02:14
 */
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    public Movie findFirstById(Integer id);
}
