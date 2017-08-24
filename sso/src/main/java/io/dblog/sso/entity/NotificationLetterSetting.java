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
public class NotificationLetterSetting extends BaseEntity {

    private Short letterPassed;

    private Short letterEmail;

    private Short notificationFocus;

    private Short notificationThumb;

}
