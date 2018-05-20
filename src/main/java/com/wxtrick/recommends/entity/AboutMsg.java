package com.wxtrick.recommends.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * “关于页”的信息表
 * @author tianyi
 * @date 2018-04-29 01:03
 */
@Entity
public class AboutMsg {
    @Id
    @GeneratedValue    //自增
    private int id;

    @NotBlank
    private String version;

    @NotBlank
    private String mail;

    public int getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
