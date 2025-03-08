package com.pichincha.customer.application.usecase;

import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.pichincha.customer.application.domain.dto.CustomerDTO;
import com.pichincha.customer.application.exception.NotFoundException;
import com.pichincha.customer.application.mapper.CustomerMapper;
import com.pichincha.customer.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final CustomerMapper customerMapper;

    public CustomerDTO edit(Long id, String fullName) throws NotFoundException {
        CustomerEntity entity = persistenceCustomerPort.find(id);
        entity.setFullName(fullName);
        return customerMapper.toDTO(persistenceCustomerPort.save(entity));
    }
}
