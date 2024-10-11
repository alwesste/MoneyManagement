package com.leopold.moneyManagemet.repositories;

import com.leopold.moneyManagemet.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
