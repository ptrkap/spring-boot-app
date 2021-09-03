package com.bank.controllers;

import com.bank.domain.Person;
import com.bank.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @GetMapping("/person/{name}")
    public Person getPerson(@PathVariable String name) {
        return personRepository.findByName(name);
    }

    @PutMapping("/person/id={id}&name={name}&age={age}")
    public void updatePerson(@PathVariable Long id, @PathVariable String name) {

        personRepository.save(new Person());
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Long id){

    }
}
