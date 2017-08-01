package io.dblog.sso.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by Pelin on 17/8/1.
 */
@Data
@Entity
public class PrivateLetter extends BaseEntity {

    private Integer accountId;

    private Integer letterBy;

    private String content;
}
