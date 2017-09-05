package io.dblog.sso.repository;

import io.dblog.jpa.sso.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pelin on 17/8/1.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, QueryDslPredicateExecutor {

    Account findByUserName(String userName);

    Account findByUserNameOrEmail(String userName, String email);
}