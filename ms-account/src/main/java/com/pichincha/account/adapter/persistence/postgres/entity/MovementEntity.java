package com.pichincha.account.adapter.persistence.postgres.entity;

import com.pichincha.account.application.domain.type.MovementType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "movement")
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private MovementType type;

    @ManyToOne
    @JoinColumn(name = "account", nullable = false)
    private AccountEntity account;

}
