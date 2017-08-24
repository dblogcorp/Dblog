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
public class AccountRelationship extends BaseEntity {

    private Integer accountId;

    private Short type;

    private Integer relationAccountId;
}
