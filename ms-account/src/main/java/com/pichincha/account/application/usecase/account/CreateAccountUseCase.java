package com.pichincha.account.application.usecase.account;

import com.pichincha.account.adapter.persistence.postgres.entity.AccountEntity;
import com.pichincha.account.application.domain.dto.AccountDTO;
import com.pichincha.account.application.mapper.AccountMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CreateAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public AccountDTO create(AccountDTO dto) {
        AccountEntity entity = accountMapper.toEntity(dto);
        var accountEntity = persistenceAccountPort.save(entity);
        log.info("Create customer: {}", accountEntity.getId());
        return accountMapper.toDTO(persistenceAccountPort.save(accountEntity));
    }

}
