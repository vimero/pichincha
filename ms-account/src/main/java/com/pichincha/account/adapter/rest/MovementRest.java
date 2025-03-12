package com.pichincha.account.adapter.rest;


import com.pichincha.account.application.domain.dto.MovementDTO;
import com.pichincha.account.application.exception.BalanceNotAvailableException;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.usecase.movement.CreateMovementUseCase;
import com.pichincha.account.application.usecase.movement.ReadMovementUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/movements")
public class MovementRest {

    private CreateMovementUseCase createMovementUseCase;
    private ReadMovementUseCase readMovementUseCase;

    @GetMapping
    public List<MovementDTO> read(){
        return readMovementUseCase.read();
    }

    @PostMapping
    public MovementDTO create(@Valid @RequestBody MovementDTO request) throws NotFoundException, BalanceNotAvailableException {
        return createMovementUseCase.create(request);
    }

}
