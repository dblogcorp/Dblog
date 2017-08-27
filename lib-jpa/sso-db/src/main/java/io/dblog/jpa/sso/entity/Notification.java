package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * {@code Notification}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
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
