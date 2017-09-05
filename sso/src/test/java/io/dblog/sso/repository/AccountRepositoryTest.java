package io.dblog.sso.repository;

import io.dblog.jpa.sso.entity.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * {@code AccountRepositoryTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class AccountRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testFindOne() {
        Account account = accountRepository.findOne(1);

        assertNotNull("AccountRepository findOne() failed, result is null", account);
    }

    @Test
    public void testFindAll() {
        List<Account> list = accountRepository.findAll();

        assertNotNull("AccountRepository findAll() failed, result is null", list);
    }

    @Test
    public void testSave() {
        Account account = new Account();

        account.setStatus((short) 1);
        account.setEmail("test@gmail.com");
        account.setEmailValidation(false);
        account.setUserName("Test");
        account.setName("测试");
        account.setPassword("123456");
        account.setGravatar("Test");
        account.setSex((short) 1);

        assertNotNull(
                "AccountRepository save() failed",
                accountRepository.save(account)
        );
    }
}
