package com.bank.person;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class PersonService {

    List<Person> getPeople(List<Person> people) {
        if (!people.isEmpty()) {
            return people;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
