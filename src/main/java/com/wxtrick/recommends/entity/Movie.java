package com.wxtrick.recommends.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 推荐电影信息概况表
 * @author tianyi
 * @date 2018-04-29 01:04
 */
@Entity
public class Movie {
    @Id
    @GeneratedValue    //自增
    private int id;

    @NotNull
    private int doubanId;

    @NotBlank
    private String qiniuUrl;

    @NotBlank
    private String reason;

    public int getId() {
        return id;
    }

    public int getDoubanId() {
        return doubanId;
    }

    public void setDoubanId(int doubanId) {
        this.doubanId = doubanId;
    }

    public String getQiniuUrl() {
        return qiniuUrl;
    }

    public void setQiniuUrl(String qiniuUrl) {
        this.qiniuUrl = qiniuUrl;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
