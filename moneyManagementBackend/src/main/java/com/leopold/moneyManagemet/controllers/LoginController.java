package com.leopold.moneyManagemet.controllers;

import com.leopold.moneyManagemet.dto.LoginRequest;
import com.leopold.moneyManagemet.dto.LoginResponse;
import com.leopold.moneyManagemet.models.SubscriberData;
import com.leopold.moneyManagemet.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/connexion")
    public ResponseEntity<?> handleLoginForm(@RequestBody LoginRequest loginRequest) {

        SubscriberData subscriberData = subscriberService.validateLogin(loginRequest.getUsername(), loginRequest.getPassword());
        if (subscriberData != null) {
            return ResponseEntity.ok(new LoginResponse(subscriberData.getId(), "Connexion réussie"));

        }
        else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}