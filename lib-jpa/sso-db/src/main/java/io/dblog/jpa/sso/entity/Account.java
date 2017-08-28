package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@code Account}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@Entity
@Table(name = "`accounts`")
@EqualsAndHashCode(callSuper=false)
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
