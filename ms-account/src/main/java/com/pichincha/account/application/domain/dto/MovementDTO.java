package com.pichincha.account.application.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovementDTO {

    private String id;

    private double balance;

    private double amount;

    private String type;

    private long account;

    private String date;

}
