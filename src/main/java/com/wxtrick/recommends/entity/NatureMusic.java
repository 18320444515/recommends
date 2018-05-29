package com.wxtrick.recommends.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * @author tianyi
 * @date 2018-05-27 09:53
 */
@Entity
public class NatureMusic {
    @Id
    @GeneratedValue    //自增
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String url;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
