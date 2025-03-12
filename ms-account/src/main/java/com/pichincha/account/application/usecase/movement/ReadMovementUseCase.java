package com.pichincha.account.application.usecase.movement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.account.application.domain.dto.MovementDTO;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.mapper.MovementMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import com.pichincha.account.application.port.input.PersistenceMovementPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
public class ReadMovementUseCase {

    private static final DateTimeFormatter DATE_RANGE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final PersistenceMovementPort persistenceMovementPort;
    private final PersistenceAccountPort persistenceAccountPort;
    private final MovementMapper accountMapper;
    private final ObjectMapper objectMapper;

    public List<MovementDTO> read() {
        return accountMapper.toDTOList(persistenceMovementPort.read());
    }

    public List<MovementDTO> findByAccount(Long accountId) throws NotFoundException {
        persistenceAccountPort.find(accountId);
        return accountMapper.toDTOList(persistenceMovementPort.findByAccount(accountId));
    }

    public List<MovementDTO> findByAccountAndRange(Long accountId, String from, String to) throws NotFoundException {
        persistenceAccountPort.find(accountId);
        return accountMapper.toDTOList(persistenceMovementPort.findByAccountAndRange
                (accountId, parseDateFrom(from), parseDateTo(to)));
    }

    public List<MovementDTO> findByCustomerAndRange(Long accountId, String from, String to) {
        return accountMapper.toDTOList(persistenceMovementPort.findByCustomerAndRange
                (accountId, parseDateFrom(from), parseDateTo(to)));
    }

    public Map<String, Object> findByCustomerAndRangeJson(Long customerId, String from, String to) {
        try {
            String jsonString = (String) persistenceMovementPort.findByCustomerAndRangeJson(customerId, parseDateFrom(from), parseDateTo(to)).get("result");
            return objectMapper.readValue(jsonString, Map.class);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return Map.of();
    }

    private LocalDateTime parseDateFrom(String date) {
        return LocalDateTime.parse(date + " 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    private LocalDateTime parseDateTo(String date) {
        return LocalDateTime.parse(date + " 23:59:59", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

}
