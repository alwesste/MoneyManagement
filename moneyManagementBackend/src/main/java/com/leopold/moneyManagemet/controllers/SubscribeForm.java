package com.leopold.moneyManagemet.controllers;

import com.leopold.moneyManagemet.models.SubscriberData;
import com.leopold.moneyManagemet.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/subscribe")
@CrossOrigin(origins = "http://localhost:4200")
public class SubscribeForm {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/form")
    public ResponseEntity<?> handleFormSubmission(@RequestBody SubscriberData subscriberData) {

        if (subscriberData.getPassword() == null || !subscriberData.getPassword().equals(subscriberData.getPasswordConfirm())) {
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        }
        subscriberService.addSubscriber(subscriberData);

        return new ResponseEntity<>(Map.of("message", "Form submitted successfully!"), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> sendNameOfSubscriber(@PathVariable String username) {
        SubscriberData subscriberData = subscriberService.getSubscriberByUsername(username);
        System.out.println("requete get fontionne" + subscriberData);
        return new ResponseEntity<>(subscriberData, HttpStatus.OK);
    }
}
