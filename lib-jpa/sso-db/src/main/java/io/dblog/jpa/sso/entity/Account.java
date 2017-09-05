package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@code Account}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Entity
@Table(name = "`accounts`")
@Data
@EqualsAndHashCode(callSuper=false)
public class Account extends BaseEntity {

    @Column(name = "`status`")
    private Short status;

    @Column(name = "`email`")
    private String email;

    @Column(name = "`email_validation`")
    private Boolean emailValidation;

    @Column(name = "`user_name`")
    private String userName;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`gravatar`")
    private String gravatar;

    @Column(name = "`role`")
    private Integer role;

    @Column(name = "`sex`")
    private Short sex;

    @Column(name = "`location`")
    private String location;

    @Column(name = "`company`")
    private String company;

    @Column(name = "`website`")
    private String website;

    @Column(name = "`github_add`")
    private String githubAdd;

    @Column(name = "`sign`")
    private String sign;

    @Column(name = "`coding_ass`")
    private String codingAdd;

    @Column(name = "`twitter_ass`")
    private String twitterAdd;

    @Column(name = "`weibo_add`")
    private String weiboAdd;

    @Column(name = "`zhihu_add`")
    private String zhihuAdd;

    @Column(name = "`intro`")
    private String intro;

    @Column(name = "`user_agemt`")
    private String userAgent;

    @Column(name = "`register_ip`")
    private String registerIp;
}
