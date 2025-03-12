package com.pichincha.account.application.usecase.movement;

import com.pichincha.account.application.domain.dto.MovementDTO;
import com.pichincha.account.application.mapper.MovementMapper;
import com.pichincha.account.application.port.input.PersistenceMovementPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReadMovementUseCase {

    private final PersistenceMovementPort persistenceMovementPort;
    private final MovementMapper accountMapper;

    public List<MovementDTO> read() {
        return accountMapper.toDTOList(persistenceMovementPort.read());
    }

}
