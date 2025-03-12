package com.pichincha.account.adapter.event.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.account.application.domain.dto.AccountDTO;
import com.pichincha.account.application.usecase.account.CreateAccountUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    private CreateAccountUseCase createAccountUseCase;
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "account-create", groupId = "grupo-consumidores")
    public void listen(ConsumerRecord<String, String> message) {
        log.debug("Consumer record: {}", message);
        log.info("Consumer record: {}", message.value());
        try {
            AccountDTO accountDTO = objectMapper.readValue(message.value(), AccountDTO.class);
            createAccountUseCase.create(accountDTO);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
    }

}
