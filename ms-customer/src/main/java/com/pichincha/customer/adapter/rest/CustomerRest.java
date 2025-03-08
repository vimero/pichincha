package com.pichincha.customer.adapter.rest;


import com.pichincha.customer.application.domain.dto.CustomerDTO;
import com.pichincha.customer.application.exception.NotFoundException;
import com.pichincha.customer.application.usecase.CreateCustomerUseCase;
import com.pichincha.customer.application.usecase.DeleteCustomerUseCase;
import com.pichincha.customer.application.usecase.EditCustomerUseCase;
import com.pichincha.customer.application.usecase.ReadCustomerUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerRest {

    private CreateCustomerUseCase createCustomerUseCase;
    private ReadCustomerUseCase readCustomerUseCase;
    private EditCustomerUseCase editCustomerUseCase;
    private DeleteCustomerUseCase deleteCustomerUseCase;

    @GetMapping
    public List<CustomerDTO> read(){
        return readCustomerUseCase.read();
    }

    @PostMapping
    public CustomerDTO create(@Valid @RequestBody CustomerDTO request){
        return createCustomerUseCase.create(request);
    }

    @PutMapping("/{id}")
    public CustomerDTO edit(@PathVariable("id")Long id, @RequestParam String fullName) throws NotFoundException {
        return editCustomerUseCase.edit(id, fullName);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) throws NotFoundException {
        deleteCustomerUseCase.delete(id);
    }

}
