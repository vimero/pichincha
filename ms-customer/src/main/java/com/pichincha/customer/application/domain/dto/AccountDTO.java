package com.pichincha.customer.application.domain.dto;

import com.pichincha.customer.application.domain.type.AccountStatus;
import com.pichincha.customer.application.domain.type.AccountType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class AccountDTO {

    private Long customer;
    private AccountType type;
    private AccountStatus status;

}
