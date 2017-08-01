package io.dblog.sso.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by Pelin on 17/8/1.
 */
@Data
@Entity
public class AccountRelationship extends BaseEntity {

    private Integer accountId;

    private Short type;

    private Integer relationAccountId;
}
