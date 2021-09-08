package com.bank.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@RestController
@RequiredArgsConstructor
@ConfigurationProperties
@PropertySource("classpath:misc.properties")
public class AccountController {

//    @Autowired
//    Environment environment;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${org.foo}")
    private String foo;

    private final AccountRepository accountRepository;
    private final AccountService accountService;

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

    @GetMapping("/all-accounts")
    public List<Account> getAllAccounts() {
//        environment.getProperty("spring.datasource.url");
        return accountRepository.findAll(Sort.by(Sort.Direction.ASC, "balance"));
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(@PathParam("balance") BigDecimal balance){
        List<Account> accounts = accountRepository.findByBalance(balance);
        return accountService.getAccounts(accounts);
    }

    @PutMapping("accounts/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
        Account account = getAccount(id);
        account.setBalance(accountDTO.getBalance());
        accountRepository.save(account);
    }

    @DeleteMapping("accounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        Account account = new Account();
        account.setId(id);
        accountRepository.delete(account);
    }
}
