package io.dblog.sso.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by Pelin on 17/7/31.
 */
@Data
@Entity
public class Account extends BaseEntity {

    private Short status;

    private String email;

    private Boolean emailValidation;

    private String userName;

    private String name;

    private String password;

    private String gravatar;

    private Integer role;

    private Short sex;

    private String location;

    private String company;

    private String website;

    private String githubAdd;

    private String sign;

    private String codingAdd;

    private String twitterAdd;

    private String weiboAdd;

    private String zhihuAdd;

    private String intro;

    private String userAgent;

    private String registerIp;
}
