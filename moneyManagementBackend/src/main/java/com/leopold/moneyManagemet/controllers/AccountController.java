package com.leopold.moneyManagemet.controllers;

import com.leopold.moneyManagemet.models.Account;
import com.leopold.moneyManagemet.models.SubscriberData;
import com.leopold.moneyManagemet.services.AccountService;
import com.leopold.moneyManagemet.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/accountSend")
    public ResponseEntity<?> addAccount(@RequestBody Account account) {
        Integer subscriberId = account.getSubscriber().getId(); // Get the subscriber ID from the account request
        System.out.println("account " + account.getSubscriber());
        System.out.println("subscriberId " + subscriberId);

        // Fetch the SubscriberData entity from the database using the subscriberId
        Optional<SubscriberData> optionalSubscriber = subscriberService.getSubscriberById(subscriberId);

        if (optionalSubscriber.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid subscriber ID.");
        }
        SubscriberData subscriber = optionalSubscriber.get();
        System.out.println("subscriber depuis le controller" + subscriber);

        account.setSubscriber(subscriber); // Set the SubscriberData object in the Account entity

        accountService.addAccount(account); // Save the account with the subscriber
        return ResponseEntity.ok().build();
    }


    @GetMapping("/spending/{subscriberId}")
    public ResponseEntity<?> getSpending(@PathVariable Integer subscriberId) {
        Optional<SubscriberData> optionalSubscriber = subscriberService.getSubscriberById(subscriberId);
        if (optionalSubscriber.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid subscriber ID.");
        }
        List<Account> spendings = accountService.getAccountBySubscriberId(subscriberId);
        if (spendings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No spendings found for this subscriber.");
        }
        return ResponseEntity.ok().body(spendings);
    }

    @GetMapping("/spending/totalBalance/{subscriberId}")
    public ResponseEntity<?> getSpendingTotalBalance(@PathVariable Integer subscriberId) {
        double totalBalance = accountService.calculateBalance(subscriberId);
        return ResponseEntity.ok().body(totalBalance);
    }


    @DeleteMapping("/spending/{spendingId}")
    public ResponseEntity<?> deleteSpending(@PathVariable Integer spendingId) {
        if (spendingId == null) {
            return ResponseEntity.badRequest().body("Invalid spending ID.");
        }
        int isDeleted = accountService.deleteAccountById(spendingId);
        // Si c'est 1 Suppression reussie 0 oui autre valeur Aucue suppression effectue
        return isDeleted == 1 ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
