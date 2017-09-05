package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@code PrivateLetter}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Entity
@Table(name = "`private_letters`")
@Data
@EqualsAndHashCode(callSuper=false)
public class PrivateLetter extends BaseEntity {

    @Column(name = "`account_id`")
    private Integer accountId;

    @Column(name = "`letter_by`")
    private Integer letterBy;

    @Column(name = "`content`")
    private String content;
}