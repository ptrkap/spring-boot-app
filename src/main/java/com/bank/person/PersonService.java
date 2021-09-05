package com.bank.person;

import com.bank.Filter;
import com.bank.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final Filter<Person> filter;

    List<Person> getPeople(List<Person> people) {
        return filter.filter(people);
    }
}
