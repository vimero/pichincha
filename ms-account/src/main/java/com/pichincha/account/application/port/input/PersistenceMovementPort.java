package com.pichincha.account.application.port.input;

import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import com.pichincha.account.application.exception.NotFoundException;

import java.util.List;

public interface PersistenceMovementPort {

    MovementEntity save(MovementEntity entity);

    List<MovementEntity> read();

    MovementEntity find(Long id) throws NotFoundException;

}
