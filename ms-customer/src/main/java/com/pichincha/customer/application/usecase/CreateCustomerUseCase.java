package com.pichincha.customer.application.usecase;

import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.pichincha.customer.application.domain.dto.CustomerDTO;
import com.pichincha.customer.application.mapper.CustomerMapper;
import com.pichincha.customer.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CreateCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final CustomerMapper customerMapper;

    public CustomerDTO create(CustomerDTO dto){
        log.info("Create customer");
        CustomerEntity entity = persistenceCustomerPort.save(customerMapper.toEntity(dto));

        return customerMapper.toDTO(entity);
    }

}
