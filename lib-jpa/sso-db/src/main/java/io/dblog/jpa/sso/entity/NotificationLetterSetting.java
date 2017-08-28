package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@code NotificationLetterSetting}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@Entity
@Table(name = "`notification_letter_settings`")
@EqualsAndHashCode(callSuper=false)
public class NotificationLetterSetting extends BaseEntity {

    private Short letterPassed;

    private Short letterEmail;

    private Short notificationFocus;

    private Short notificationThumb;

}
