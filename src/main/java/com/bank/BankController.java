package com.bank.controllers;

import com.bank.repository.PersonRepository;
import com.bank.domain.Account;
import com.bank.domain.Person;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class BankController {



    @GetMapping("/")
    public String sayHello(){
        return "hello there";
    }





//    @PostMapping("/addperson")
//    public void savePerson(@RequestBody Person person) {
////        bankPersistence.save(new Person(6l, "name6", 66));
//        personRepository.save(person);
//    }





//    @GetMapping("/persons")
//    public List<Person> getPersons() {
//        List<Person> persons = List.of(
//                personRepository.findByName("name1"),
//                personRepository.findByName("name2"),
//                new Person(3l, "name3", 33),
//                new Person(4l,"name4", 44)
//        );
//        return persons;
//    }


//    @GetMapping("accounts")
//    public List<Account> getAccounts() {
//        List<Account> accounts = List.of(
//                new Account(1l, new Person(1l,"name1", 33), new BigDecimal("2332.43")),
//                new Account(2l, new Person(2l,"name2", 44), new BigDecimal("3332.43"))
//        );
//        return accounts;
//    }
}
