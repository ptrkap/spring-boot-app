package com.bank.account;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AccountController {

    private AccountRepository accountRepository;
    private AccountService accountService;

    @PostMapping("/account")
    public void addAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll(Sort.by(Sort.Direction.ASC, "balance"));
    }

    @GetMapping("/accounts/balance={balance}")
    public List<Account> getAccounts(@PathVariable BigDecimal balance){
        List<Account> accounts = accountRepository.findByBalance(balance);
        return accountService.getAccounts(accounts);
    }

    @PutMapping("accounts/id={id}&balance={balance}")
    public void updateAccount(@PathVariable Long id, @PathVariable BigDecimal balance) {
        Account account = getAccount(id);
        account.setBalance(balance);
        accountRepository.save(account);
    }

    @DeleteMapping("accounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        Account account = new Account();
        account.setId(id);
        accountRepository.delete(account);
    }
}
