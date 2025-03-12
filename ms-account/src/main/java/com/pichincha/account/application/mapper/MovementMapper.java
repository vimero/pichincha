package com.pichincha.account.application.mapper;

import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import com.pichincha.account.application.domain.dto.MovementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MovementMapper {

    @Mapping(target = "account", ignore = true)
    MovementEntity toEntity(MovementDTO dto);

    @Mapping(source = "account.id", target = "account")
    MovementDTO toDTO(MovementEntity entity);

    List<MovementDTO> toDTOList(List<MovementEntity> list);

}
