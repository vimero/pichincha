package com.pichincha.account.infraestructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.account.application.mapper.MovementMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import com.pichincha.account.application.port.input.PersistenceMovementPort;

import com.pichincha.account.application.usecase.movement.CreateMovementUseCase;
import com.pichincha.account.application.usecase.movement.ReadMovementUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovementConfiguration {

    @Bean
    CreateMovementUseCase createMovementUseCase(PersistenceMovementPort persistenceMovementPort, PersistenceAccountPort persistenceAccountPort, MovementMapper accountMapper) {
        return new CreateMovementUseCase(persistenceMovementPort, persistenceAccountPort, accountMapper);
    }

    @Bean
    ReadMovementUseCase readMovementUseCase(PersistenceMovementPort persistenceMovementPort, PersistenceAccountPort persistenceAccountPort,
                                            MovementMapper movementMapper, ObjectMapper objectMapper) {
        return new ReadMovementUseCase(persistenceMovementPort, persistenceAccountPort, movementMapper, objectMapper);
    }

}
