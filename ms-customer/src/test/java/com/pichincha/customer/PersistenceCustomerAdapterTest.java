package com.pichincha.customer;


import com.pichincha.customer.adapter.persistence.PersistenceCustomerAdapter;
import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.pichincha.customer.adapter.persistence.postgres.repository.CustomerRepository;
import com.pichincha.customer.application.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class, OutputCaptureExtension.class})
class PersistenceCustomerAdapterTest {

    @InjectMocks
    private PersistenceCustomerAdapter persistenceCustomerAdapter;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void findById_ShouldGetEntityNotNull_WhenExistEntity(CapturedOutput output) throws NotFoundException {

        //Given
        Long id = 1L;
        when(customerRepository.findById(id)).thenReturn(Optional.of(new CustomerEntity()));

        //When
        CustomerEntity entity = persistenceCustomerAdapter.find(id);

        //Then
        assertThat(output).contains("Find customer by id " + id);
        assertThat(entity).isNotNull();
    }

    @Test
    void findById_ShouldThrowNotFoundException_WhenNotExistEntity(){

        //Given
        when(customerRepository.findById(anyLong())).thenReturn(Optional.empty());

        //When and Then
        assertThrows(NotFoundException.class, () -> persistenceCustomerAdapter.find(anyLong()));
    }

}
