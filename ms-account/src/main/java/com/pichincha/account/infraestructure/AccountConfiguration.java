package com.pichincha.account.infraestructure;

import com.pichincha.account.application.mapper.AccountMapper;
import com.pichincha.account.application.port.input.PersistenceAccountPort;
import com.pichincha.account.application.usecase.account.CreateAccountUseCase;
import com.pichincha.account.application.usecase.account.DeleteAccountUseCase;
import com.pichincha.account.application.usecase.account.EditAccountUseCase;
import com.pichincha.account.application.usecase.account.ReadAccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfiguration {

    @Bean
    CreateAccountUseCase createAccountUseCase(PersistenceAccountPort persistenceAccountPort, AccountMapper accountMapper){
        return new CreateAccountUseCase(persistenceAccountPort, accountMapper);
    }

    @Bean
    ReadAccountUseCase readAccountUseCase(PersistenceAccountPort persistenceAccountPort, AccountMapper accountMapper){
        return new ReadAccountUseCase(persistenceAccountPort, accountMapper);
    }

    @Bean
    EditAccountUseCase editAccountUseCase(PersistenceAccountPort persistenceAccountPort, AccountMapper accountMapper){
        return new EditAccountUseCase(persistenceAccountPort, accountMapper);
    }

    @Bean
    DeleteAccountUseCase deleteAccountUseCase(PersistenceAccountPort persistenceAccountPort, AccountMapper accountMapper){
        return new DeleteAccountUseCase(persistenceAccountPort, accountMapper);
    }

}
