package com.pichincha.account.application.port.input;

import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import com.pichincha.account.application.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface PersistenceMovementPort {

    MovementEntity save(MovementEntity entity);

    List<MovementEntity> read();

    MovementEntity find(Long id) throws NotFoundException;

    List<MovementEntity> findByAccount(Long id);

    List<MovementEntity> findByAccountAndRange(Long id, LocalDateTime from, LocalDateTime to);

    List<MovementEntity> findByCustomerAndRange(Long id, LocalDateTime from, LocalDateTime to);

    Map<String, Object>  findByCustomerAndRangeJson(Long id, LocalDateTime from, LocalDateTime to);
}
