package com.bank.account;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class AccountService {

    List<Account> getAccounts(List<Account> accounts) {
        if (!accounts.isEmpty()) {
            return accounts;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
