package io.dblog.jpa.sso.entity;

import io.dblog.jpa.sso.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@code NotificationLetterSetting}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Entity
@Table(name = "`notification_letter_settings`")
@Data
@EqualsAndHashCode(callSuper=false)
public class NotificationLetterSetting extends BaseEntity {

    @Column(name = "`letter_passed`")
    private Short letterPassed;

    @Column(name = "`letter_email`")
    private Short letterEmail;

    @Column(name = "`notification_focus`")
    private Short notificationFocus;

    @Column(name = "`notification_thumb`")
    private Short notificationThumb;

}
