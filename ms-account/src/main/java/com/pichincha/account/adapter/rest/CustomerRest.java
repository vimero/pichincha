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
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerRest {

    private ReadMovementUseCase readMovementUseCase;

    @GetMapping("/{id}/movements")
    public List<MovementDTO> movements(@PathVariable("id") Long id,
                                       @RequestParam(value = "from") String from,
                                       @RequestParam(value = "to") String to) {
        return readMovementUseCase.findByCustomerAndRange(id, from, to);
    }

    @GetMapping("/{id}/movements/json")
    public Map<String, Object> movementsJson(@PathVariable("id") Long id,
                                             @RequestParam(value = "from") String from,
                                             @RequestParam(value = "to") String to) {
        return readMovementUseCase.findByCustomerAndRangeJson(id, from, to);
    }


}
