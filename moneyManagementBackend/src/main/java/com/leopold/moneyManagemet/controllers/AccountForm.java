package com.leopold.moneyManagemet.controllers;

import com.leopold.moneyManagemet.models.Account;
import com.leopold.moneyManagemet.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountForm {

    @Autowired
    private AccountService accountService;

    @PostMapping("/accountSend")
    public ResponseEntity<?> addAcount(@RequestBody Account account) {
        accountService.addAccount(account);
        return ResponseEntity.ok().build();
    }
}
