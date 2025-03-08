package com.pichincha.customer.application.port.input;

import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.pichincha.customer.application.exception.NotFoundException;

import java.util.List;

public interface PersistenceCustomerPort {

    CustomerEntity save(CustomerEntity entity);

    List<CustomerEntity> read();

    CustomerEntity find(Long id) throws NotFoundException;

    void delete(CustomerEntity entity) throws NotFoundException;

}
