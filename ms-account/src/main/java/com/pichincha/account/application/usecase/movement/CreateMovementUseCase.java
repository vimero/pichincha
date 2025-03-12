package com.pichincha.account.application.usecase.movement;

import com.pichincha.account.adapter.persistence.postgres.entity.AccountEntity;
import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import com.pichincha.account.application.domain.dto.MovementDTO;
import com.pichincha.account.application.domain.type.MovementType;
import com.pichincha.account.application.exception.BalanceNotAvailableException;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.mapper.MovementMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import com.pichincha.account.application.port.input.PersistenceMovementPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
public class CreateMovementUseCase {

    private final PersistenceMovementPort persistenceMovementPort;
    private final PersistenceAccountPort persistenceAccountPort;
    private final MovementMapper movementMapper;

    public MovementDTO create(MovementDTO dto) throws NotFoundException, BalanceNotAvailableException {
        MovementEntity entity = movementMapper.toEntity(dto);
        entity.setDate(LocalDateTime.now());
        AccountEntity account = persistenceAccountPort.find(dto.getAccount());
        entity.setAccount(account);
        if (MovementType.WITHDRAWAL.equals(MovementType.valueOf(dto.getType()))) {
            if (account.getBalance() - dto.getAmount() >= 0) {
                entity.setBalance(account.getBalance() - dto.getAmount());
                account.setBalance(entity.getBalance());
            } else {
                throw new BalanceNotAvailableException();
            }
        } else {
            entity.setBalance(account.getBalance() + dto.getAmount());
            account.setBalance(entity.getBalance());
        }
        var movementEntity = persistenceMovementPort.save(entity);
        persistenceAccountPort.update(account);
        log.info("Create customer: {}", movementEntity.getId());
        return movementMapper.toDTO(movementEntity);
    }

}
