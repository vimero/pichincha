package com.pichincha.customer.application.usecase;

import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.pichincha.customer.application.exception.NotFoundException;
import com.pichincha.customer.application.mapper.CustomerMapper;
import com.pichincha.customer.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCustomerUseCase {

    private final PersistenceCustomerPort persistenceCustomerPort;
    private final CustomerMapper customerMapper;

    public void delete(Long id) throws NotFoundException {
        CustomerEntity entity = persistenceCustomerPort.find(id);
        persistenceCustomerPort.delete(entity);
    }
}
