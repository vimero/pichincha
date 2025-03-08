package com.pichincha.customer.application.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Long id;

    private String fullName;

    private String gender;

    private int age;

    private String identification;

    private String address;

    private String phone;

    private String clientId;

    private String password;

    private String status;

}
