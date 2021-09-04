package com.bank.account;

import com.bank.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Account {
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private BigDecimal balance;
}
