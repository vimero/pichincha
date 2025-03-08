package com.pichincha.customer.adapter.persistence;

import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.pichincha.customer.adapter.persistence.postgres.repository.CustomerRepository;
import com.pichincha.customer.application.exception.NotFoundException;
import com.pichincha.customer.application.port.input.PersistenceCustomerPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PersistenceCustomerAdapter implements PersistenceCustomerPort {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return customerRepository.save(entity);
    }

    @Override
    public List<CustomerEntity> read() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity find(Long id) throws NotFoundException {
        log.info("Find customer by id {}", id);
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer " + id + " not found"));
    }

    @Override
    public void delete(CustomerEntity entity) {
        entity.setActive(false);
        customerRepository.save(entity);
    }

}
