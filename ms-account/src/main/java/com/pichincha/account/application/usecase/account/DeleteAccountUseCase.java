package com.pichincha.account.application.usecase.account;

import com.pichincha.account.adapter.persistence.postgres.entity.AccountEntity;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.mapper.AccountMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public void delete(Long id) throws NotFoundException {
        AccountEntity entity = persistenceAccountPort.find(id);
        persistenceAccountPort.delete(entity);
    }
}
