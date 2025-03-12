package com.pichincha.customer.adapter.event.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.customer.application.domain.dto.AccountDTO;
import com.pichincha.customer.application.port.output.AccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaProducer implements AccountPort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void createAccount(AccountDTO accountDTO) {
        try{
            log.info("Create account : {}", accountDTO);
            var json = objectMapper.writeValueAsString(accountDTO);
            kafkaTemplate.send("account-create", json);
        }catch (Exception e){
            log.error("Error: ", e);
        }

    }
}
