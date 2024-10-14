package com.leopold.moneyManagemet.services;

import com.leopold.moneyManagemet.models.SubscriberData;
import com.leopold.moneyManagemet.repositories.SubscriberDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriberService {

    @Autowired
    SubscriberDataRepository subscriberDataRepository;

    public SubscriberData addSubscriber(SubscriberData subscriberData) {
        return subscriberDataRepository.save(subscriberData);
    }

    public Iterable<SubscriberData> getAllSubscriber(SubscriberData subscriberData) {
        return subscriberDataRepository.findAll();
    }

    public boolean existSubscriber(SubscriberData subscriberData) {
        return subscriberDataRepository.findByUsername(subscriberData.getUsername()) != null;
    }

    public Optional<SubscriberData> getSubscriberById(Integer id) {
        return subscriberDataRepository.findById(id);
    }

    public SubscriberData getSubscriberByUsername(String username) {
        return subscriberDataRepository.findByUsername(username);
    }

    public Iterable<SubscriberData> getAllSubscribers() {
        return subscriberDataRepository.findAll();
    }

    public SubscriberData validateLogin(String username, String password) {
        SubscriberData subscriberData = getSubscriberByUsername(username);

        if (subscriberData.getPassword().equals(password) && subscriberData.getUsername().equals(username)) {
            System.out.println("reponse du serveur "+ subscriberData.getId());
            return subscriberData;
        }
        return null;
    }

}
