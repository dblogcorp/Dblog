package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * {@code AccountRelationship}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class AccountRelationship extends BaseEntity {

    private Integer accountId;

    private Short type;

    private Integer relationAccountId;
}
