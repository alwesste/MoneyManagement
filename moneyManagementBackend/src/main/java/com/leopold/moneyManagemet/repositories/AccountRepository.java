package com.leopold.moneyManagemet.repositories;

import com.leopold.moneyManagemet.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    List<Account> findBySubscriberId(Integer subscriberId);

    int deleteAccountById(@Param("accountId") Integer accountId);
}
