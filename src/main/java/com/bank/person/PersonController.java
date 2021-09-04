package com.bank.controllers;

import com.bank.domain.Person;
import com.bank.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/persons/{name}")
    public List<Person> getPersons(@PathVariable String name) {
        List<Person> persons = personRepository.findByName(name);
        if (!persons.isEmpty()) {
            return persons;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/person/id={id}&name={name}&age={age}")
    public void updatePerson(@PathVariable Long id, @PathVariable String name) {

        personRepository.save(new Person());
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Long id){

    }
}
