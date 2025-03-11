package com.pichincha.account.application.usecase.account;

import com.pichincha.account.adapter.persistence.postgres.entity.AccountEntity;
import com.pichincha.account.application.domain.dto.AccountDTO;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.mapper.AccountMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public AccountDTO edit(Long id, double balance) throws NotFoundException {
        AccountEntity entity = persistenceAccountPort.find(id);
        entity.setBalance(balance);
        return accountMapper.toDTO(persistenceAccountPort.save(entity));
    }
}
