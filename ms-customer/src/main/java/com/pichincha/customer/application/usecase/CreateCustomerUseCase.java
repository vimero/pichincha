package com.pichincha.customer.application.usecase;

import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.pichincha.customer.application.domain.dto.AccountDTO;
import com.pichincha.customer.application.domain.dto.CustomerDTO;
import com.pichincha.customer.application.domain.type.AccountStatus;
import com.pichincha.customer.application.domain.type.AccountType;
import com.pichincha.customer.application.mapper.CustomerMapper;
import com.pichincha.customer.application.port.input.PersistenceCustomerPort;
import com.pichincha.customer.application.port.output.AccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CreateCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final AccountPort accountPort;
    private final CustomerMapper customerMapper;

    public CustomerDTO create(CustomerDTO dto) {
        log.info("Create customer");
        CustomerEntity entity = persistenceCustomerPort.save(customerMapper.toEntity(dto));
        AccountDTO account = AccountDTO.builder()
                .customer(entity.getId())
                .status(AccountStatus.CREATED)
                .type(AccountType.SAVINGS)
                .build();
        accountPort.createAccount(account);
        return customerMapper.toDTO(entity);
    }

}
