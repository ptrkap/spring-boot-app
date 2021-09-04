package com.bank.controllers;

import com.bank.domain.Account;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class AccountController {

    @PostMapping("/account")
    public void addAccount(@RequestBody Account account) {

    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return null;
    }

    @PutMapping("account/{id}/{balance}")
    public void updateAccount(@PathVariable Long id, @PathVariable BigDecimal balance) {

    }

    @DeleteMapping("account/{id}")
    public void deleteAccount(@PathVariable Long id) {

    }
}
