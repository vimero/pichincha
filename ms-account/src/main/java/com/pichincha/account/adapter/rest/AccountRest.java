package com.pichincha.account.adapter.rest;


import com.pichincha.account.application.domain.dto.AccountDTO;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.usecase.account.CreateAccountUseCase;
import com.pichincha.account.application.usecase.account.DeleteAccountUseCase;
import com.pichincha.account.application.usecase.account.EditAccountUseCase;
import com.pichincha.account.application.usecase.account.ReadAccountUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountRest {

    private CreateAccountUseCase createAccountUseCase;
    private ReadAccountUseCase readAccountUseCase;
    private EditAccountUseCase editAccountUseCase;
    private DeleteAccountUseCase deleteAccountUseCase;

    @GetMapping
    public List<AccountDTO> read(){
        return readAccountUseCase.read();
    }

    @PostMapping
    public AccountDTO create(@Valid @RequestBody AccountDTO request){
        return createAccountUseCase.create(request);
    }

    @PutMapping("/{id}")
    public AccountDTO edit(@PathVariable("id")Long id, @RequestParam double balance) throws NotFoundException {
        return editAccountUseCase.edit(id, balance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) throws NotFoundException {
        deleteAccountUseCase.delete(id);
    }

}
