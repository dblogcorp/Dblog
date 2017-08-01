package io.dblog.sso.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by Pelin on 17/8/1.
 */
@Data
@Entity
public class Notification extends BaseEntity {

    private Integer accountId;

    private Short type;

    private Short status;

    private Integer notificationAccountId;

    private String originalTopic;

    private String originalAddress;

    private String content;
}
