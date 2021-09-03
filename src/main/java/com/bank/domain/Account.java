package com.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Account {
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private BigDecimal balance;
}
