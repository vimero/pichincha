package com.pichincha.account.adapter.persistence;

import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import com.pichincha.account.adapter.persistence.postgres.repository.MovementRepository;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.port.input.PersistenceMovementPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PersistenceMovementAdapter implements PersistenceMovementPort {

    private final MovementRepository movementRepository;

    @Override
    public MovementEntity save(MovementEntity entity) {
        return movementRepository.save(entity);
    }

    @Override
    public List<MovementEntity> read() {
        return movementRepository.findAll();
    }

    @Override
    public MovementEntity find(Long id) throws NotFoundException {
        log.info("Find movement by id {}", id);
        return movementRepository.findById(id).orElseThrow(() -> new NotFoundException("Movement " + id + " not found"));
    }

}
