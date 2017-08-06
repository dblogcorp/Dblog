package io.dblog.sso.service.account;

import io.dblog.proto.sso.api.AccountProto;
import io.dblog.sso.constant.AccountConstant;
import io.dblog.sso.entity.Account;
import io.dblog.sso.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pelin on 17/8/1.
 */
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountProto.Account toProto(Account account) {
        return AccountProto.Account.newBuilder().setId(1)
                .setStatus(
                        AccountConstant.AccountStatus.getMsg(account.getStatus())
                )
                .setEmail(account.getEmail())
                //TODO: change this boolean value, because pb not support empty and zero
                .setEmailValidation(1)
                .setUserName(account.getUserName())
                .setName("-1")
                .setGravatar(account.getGravatar())
                .setLocation(null == account.getLocation() ? "-1" : account.getLocation())
                .setCompany(null == account.getCompany() ? "-1" : account.getCompany())
                .setWebsite(null == account.getWebsite() ? "-1" : account.getWebsite())
                .setGithubAdd(null == account.getGithubAdd() ? "-1" : account.getGithubAdd())
                .setSign(null == account.getSign() ? "-1" : account.getSign())
                .build();
    }

    public Boolean checkAccountExists(String userName, String email) {
        Account account = accountRepository.findByUserNameOrEmail(userName, email);

        return null != account;
    }

    public Boolean save(Account account) {
        try {
            accountRepository.save(account);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
