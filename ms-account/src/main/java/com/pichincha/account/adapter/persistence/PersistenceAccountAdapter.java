package com.pichincha.account.adapter.persistence;

import com.pichincha.account.adapter.persistence.postgres.entity.AccountEntity;
import com.pichincha.account.adapter.persistence.postgres.repository.AccountRepository;
import com.pichincha.account.application.exception.NotFoundException;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PersistenceAccountAdapter implements PersistenceAccountPort {

    private final AccountRepository accountRepository;

    @Override
    public AccountEntity save(AccountEntity entity) {
        entity.setNumber(getCode());
        entity.setBalance(0);
        entity.setActive(true);
        return accountRepository.save(entity);
    }

    @Override
    public List<AccountEntity> read() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity find(Long id) throws NotFoundException {
        log.info("Find account by id {}", id);
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer " + id + " not found"));
    }

    @Override
    public void delete(AccountEntity entity) {
        entity.setActive(false);
        accountRepository.save(entity);
    }

    private String getCode() {
        return String.format("%020d" , accountRepository.count() + 1);
    }
}
