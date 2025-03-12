package com.pichincha.customer.infraestructure;

import com.pichincha.customer.application.mapper.CustomerMapper;
import com.pichincha.customer.application.port.input.PersistenceCustomerPort;
import com.pichincha.customer.application.port.output.AccountPort;
import com.pichincha.customer.application.usecase.CreateCustomerUseCase;
import com.pichincha.customer.application.usecase.DeleteCustomerUseCase;
import com.pichincha.customer.application.usecase.EditCustomerUseCase;
import com.pichincha.customer.application.usecase.ReadCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Bean
    CreateCustomerUseCase createCustomerUseCase(PersistenceCustomerPort persistenceCustomerPort, AccountPort accountPort, CustomerMapper customerMapper){
        return new CreateCustomerUseCase(persistenceCustomerPort, accountPort, customerMapper);
    }

    @Bean
    ReadCustomerUseCase readCustomerUseCase(PersistenceCustomerPort persistenceCustomerPort, CustomerMapper customerMapper){
        return new ReadCustomerUseCase(persistenceCustomerPort, customerMapper);
    }

    @Bean
    EditCustomerUseCase editCustomerUseCase(PersistenceCustomerPort persistenceCustomerPort, CustomerMapper customerMapper){
        return new EditCustomerUseCase(persistenceCustomerPort, customerMapper);
    }

    @Bean
    DeleteCustomerUseCase deleteCustomerUseCase(PersistenceCustomerPort persistenceCustomerPort, CustomerMapper customerMapper){
        return new DeleteCustomerUseCase(persistenceCustomerPort, customerMapper);
    }

}
