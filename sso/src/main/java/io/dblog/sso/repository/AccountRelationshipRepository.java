package io.dblog.sso.repository;

import io.dblog.sso.entity.AccountRelationship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pelin on 17/8/1.
 */
public interface AccountRelationshipRepository extends CrudRepository<AccountRelationship, Integer> {

}
