package com.pichincha.account.application.usecase.account;

import com.pichincha.account.application.domain.dto.AccountDTO;
import com.pichincha.account.application.mapper.AccountMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReadAccountUseCase {

    private final PersistenceAccountPort persistenceAccountPort;
    private final AccountMapper accountMapper;

    public List<AccountDTO> read(){
        return accountMapper.toDTOList(persistenceAccountPort.read());
    }

}
