package com.leopold.moneyManagemet.controllers;

import com.leopold.moneyManagemet.models.SubscriberData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/subscribe")
@CrossOrigin(origins = "http://localhost:4200") // Adjust origin as needed
public class SubscribeForm {

    @PostMapping("/form")
    public ResponseEntity<?> handleFormSubmission(@RequestBody SubscriberData subscriberData) {

        if (subscriberData.getPassword() == null || !subscriberData.getPassword().equals(subscriberData.getPasswordConfirm())) {
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        }

        // Map.of permet la conversion en json
        return new ResponseEntity<>(Map.of("message", "Form submitted successfully!"), HttpStatus.OK);
    }

}
