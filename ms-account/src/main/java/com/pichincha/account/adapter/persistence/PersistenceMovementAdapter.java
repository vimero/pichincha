package com.pichincha.account.adapter.persistence;

import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import com.pichincha.account.adapter.persistence.postgres.repository.MovementRepository;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.port.input.PersistenceMovementPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<MovementEntity> findByAccount(Long id) {
        return movementRepository.findByAccountId(id);
    }

    @Override
    public List<MovementEntity> findByAccountAndRange(Long id, LocalDateTime from, LocalDateTime to) {
        return movementRepository.findByAccountIdAndDateBetween(id, from, to);
    }

    @Override
    public List<MovementEntity> findByCustomerAndRange(Long id, LocalDateTime from, LocalDateTime to) {
        return movementRepository.findByCustomerIdAndDateBetween(id, from, to);
    }

    @Override
    public Map<String, Object> findByCustomerAndRangeJson(Long id, LocalDateTime from, LocalDateTime to) {
        return movementRepository.findByCustomerIdAndDateBetweenJson(id, from, to);
    }

}
