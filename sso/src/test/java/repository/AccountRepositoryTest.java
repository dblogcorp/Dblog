package repository;

import io.dblog.sso.repository.AccountRepository;
import io.dblog.sso.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * {@code AccountRepositoryTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {Application.class})
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testSave() {
        System.out.println(accountRepository);
    }
}
