package com.leopold.moneyManagemet.repositories;

import com.leopold.moneyManagemet.models.SubscriberData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberDataRepository extends CrudRepository<SubscriberData, Integer> {
    SubscriberData findByUsername(String username);
}
