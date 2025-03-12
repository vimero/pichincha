package com.pichincha.customer.application.port.output;

import com.pichincha.customer.application.domain.dto.AccountDTO;

public interface AccountPort {

    void createAccount(AccountDTO event);

}
