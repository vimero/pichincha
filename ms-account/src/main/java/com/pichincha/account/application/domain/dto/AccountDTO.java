package com.pichincha.account.application.domain.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private String number;

    private double balance;

    private String type;

    private String status;

    private Long customer;

    private boolean active;

}
