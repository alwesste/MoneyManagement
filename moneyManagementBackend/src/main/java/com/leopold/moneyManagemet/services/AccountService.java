package com.leopold.moneyManagemet.services;

import com.leopold.moneyManagemet.models.Account;
import com.leopold.moneyManagemet.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Flow;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAccountBySubscriberId(Integer subscriberId) {
        return accountRepository.findBySubscriberId(subscriberId);
    }

    @Transactional
    public int deleteAccountById(Integer accountId) {
        return accountRepository.deleteAccountById(accountId);
    }

    public double calculateBalance(Integer subscriberId) {
       List<Account> accounts = getAccountBySubscriberId(subscriberId);
       double balance = 0;

       for (Account account : accounts) {
           balance += account.getAmount();
       }
       return balance;
    }

}