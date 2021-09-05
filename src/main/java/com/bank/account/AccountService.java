package com.bank.account;

import com.bank.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${org.foo}")
    private String foo;

    @Value("${org.bar}")
    private Integer bar;

    private final Filter<Account> filter;

    List<Account> getAccounts(List<Account> accounts) {
        return filter.filter(accounts);
    }
}
