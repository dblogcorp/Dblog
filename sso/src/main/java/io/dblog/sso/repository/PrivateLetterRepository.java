package io.dblog.sso.repository;

import io.dblog.sso.entity.PrivateLetter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pelin on 17/8/1.
 */
public interface PrivateLetterRepository extends CrudRepository<PrivateLetter, Integer> {
}