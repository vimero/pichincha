package com.pichincha.account.adapter.persistence.postgres.entity;

import com.pichincha.account.application.domain.type.AccountType;
import com.pichincha.account.application.domain.type.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 20)
    private String number;

    @Column(nullable = false)
    private double balance;

    @Enumerated(EnumType.ORDINAL)
    private AccountType type;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(nullable = false)
    private Long customer;

    @Column(nullable = false)
    private boolean active;

}
