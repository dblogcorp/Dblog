package io.dblog.sso.repository;

import io.dblog.sso.entity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pelin on 17/8/1.
 */
public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findByUserName(String userName);

    Account findByUserNameOrEmail(String userName, String email);
}
