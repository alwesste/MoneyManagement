package com.leopold.moneyManagemet.services;

import com.leopold.moneyManagemet.models.Account;
import com.leopold.moneyManagemet.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }
}
