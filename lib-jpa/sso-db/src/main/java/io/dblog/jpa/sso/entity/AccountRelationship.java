package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@code AccountRelationship}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Entity
@Table(name = "`account_relationships`")
@Data
@EqualsAndHashCode(callSuper=false)
public class AccountRelationship extends BaseEntity {

    @Column(name = "`account_id`")
    private Integer accountId;

    @Column(name = "`type`")
    private Short type;

    @Column(name = "`relation_account_id`")
    private Integer relationAccountId;
}
