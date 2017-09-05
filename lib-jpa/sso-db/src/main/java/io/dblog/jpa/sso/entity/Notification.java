package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@code Notification}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Entity
@Table(name = "`notifications`")
@Data
@EqualsAndHashCode(callSuper=false)
public class Notification extends BaseEntity {

    @Column(name = "`account_id`")
    private Integer accountId;

    @Column(name = "`type`")
    private Short type;

    @Column(name = "`status`")
    private Short status;

    @Column(name = "`notification_account_id`")
    private Integer notificationAccountId;

    @Column(name = "`original_topic`")
    private String originalTopic;

    @Column(name = "`original_address`")
    private String originalAddress;

    @Column(name = "`content`")
    private String content;
}
