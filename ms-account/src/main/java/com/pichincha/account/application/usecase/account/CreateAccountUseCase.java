package com.pichincha.account.application.usecase.account;

import com.pichincha.account.adapter.persistence.postgres.entity.AccountEntity;
import com.pichincha.account.application.domain.dto.AccountDTO;
import com.pichincha.account.application.mapper.AccountMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public AccountDTO create(AccountDTO dto){
        AccountEntity entity =  accountMapper.toEntity(dto);

        return accountMapper.toDTO(persistenceAccountPort.save(entity));
    }

}
