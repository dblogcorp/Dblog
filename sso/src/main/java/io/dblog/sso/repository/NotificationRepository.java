package io.dblog.sso.repository;

import io.dblog.sso.entity.Notification;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pelin on 17/8/1.
 */
public interface NotificationRepository extends CrudRepository<Notification, Integer> {
}
