package com.bank;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BankController {

    @GetMapping("/")
    public String sayHello(){
        return "hello there";
    }

//    @GetMapping("accounts")
//    public List<Account> getAccounts() {
//        List<Account> accounts = List.of(
//                new Account(1l, new Person(1l,"name1", 33), new BigDecimal("2332.43")),
//                new Account(2l, new Person(2l,"name2", 44), new BigDecimal("3332.43"))
//        );
//        return accounts;
//    }
}
