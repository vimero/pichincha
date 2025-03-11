package com.pichincha.account.application.mapper;

import com.pichincha.account.adapter.persistence.postgres.entity.AccountEntity;
import com.pichincha.account.application.domain.dto.AccountDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountEntity toEntity(AccountDTO dto);
    AccountDTO toDTO(AccountEntity entity);

    List<AccountDTO> toDTOList(List<AccountEntity> list);
}
