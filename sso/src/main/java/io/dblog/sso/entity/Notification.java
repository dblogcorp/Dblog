package io.dblog.sso.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Created by Pelin on 17/8/1.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Notification extends BaseEntity {

    private Integer accountId;

    private Short type;

    private Short status;

    private Integer notificationAccountId;

    private String originalTopic;

    private String originalAddress;

    private String content;
}
