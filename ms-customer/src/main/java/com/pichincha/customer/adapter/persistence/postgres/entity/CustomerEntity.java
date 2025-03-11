package com.pichincha.customer.adapter.persistence.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity extends PersonEntity {


    @Column(nullable = false, length = 50)
    private String clientId;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 3)
    private String status;

}
