package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * {@code PrivateLetter}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class PrivateLetter extends BaseEntity {

    private Integer accountId;

    private Integer letterBy;

    private String content;
}