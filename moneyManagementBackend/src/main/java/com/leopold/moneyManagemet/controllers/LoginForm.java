package com.leopold.moneyManagemet.controllers;

import com.leopold.moneyManagemet.models.LoginData;
import com.leopold.moneyManagemet.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginForm {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/connexion")
    public ResponseEntity<?> handleLoginForm(@RequestBody LoginData loginData) {

        boolean isValidUser = subscriberService.validateLogin(loginData.getUsername(),loginData.getPassword());
        if (isValidUser) {
            return new ResponseEntity<>(Map.of("message", "Form submitted successfully!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }


}
