package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * {@code NotificationLetterSetting}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class NotificationLetterSetting extends BaseEntity {

    private Short letterPassed;

    private Short letterEmail;

    private Short notificationFocus;

    private Short notificationThumb;

}
