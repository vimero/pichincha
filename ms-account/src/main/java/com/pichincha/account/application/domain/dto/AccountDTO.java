package com.pichincha.account.application.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private long id;

    private String number;

    private double balance;

    private String type;

    private String status;

    private Long customer;

    private boolean active;

}
