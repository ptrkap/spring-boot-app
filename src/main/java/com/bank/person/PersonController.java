package com.bank.person;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;
    private PersonService personService;

    @PostMapping("/people")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/people")
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @GetMapping("/people/name={name}")
    public List<Person> getPeopleByName(@PathVariable String name) {
        List<Person> people = personRepository.findByName(name);
//        List<Person> people = personRepository.selectByName(name);
        return personService.getPeople(people);
    }

    @GetMapping("/people/age={age}")
    public List<Person> getPeopleByAge(@PathVariable Integer age) {
        List<Person> people = personRepository.findByAge(age);
//        List<Person> people = personRepository.selectByAge(age);
        return personService.getPeople(people);
    }

    @PutMapping("/people/id={id}&name={name}&age={age}")
    public void updatePerson(@PathVariable Long id, @PathVariable String name, @PathVariable Integer age) {
        personRepository.save(new Person(id, name, age));
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable Long id) {
        try {
            personRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
