package com.leopold.moneyManagemet.repositories;

import com.leopold.moneyManagemet.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository <Account, Long>{

}
