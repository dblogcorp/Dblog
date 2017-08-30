package io.dblog.sso.repository;

import io.dblog.jpa.sso.entity.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * {@code AccountRepositoryTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class AccountRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testSave() {
        Account account = accountRepository.findOne(1);

        System.out.println(account);

    }
}
