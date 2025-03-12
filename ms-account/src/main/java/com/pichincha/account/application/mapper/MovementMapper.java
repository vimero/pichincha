package com.pichincha.account.application.mapper;

import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import com.pichincha.account.application.domain.dto.MovementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper
public interface MovementMapper {

    @Mapping(target = "account", ignore = true)
    @Mapping(target = "date", ignore = true)
    MovementEntity toEntity(MovementDTO dto);

    @Mapping(source = "account.id", target = "account")
    @Mapping(source = "date", target = "date", qualifiedByName = "convertDate")
    MovementDTO toDTO(MovementEntity entity);

    List<MovementDTO> toDTOList(List<MovementEntity> list);

    @Named("convertDate")
    default String convertDate(LocalDateTime date) {
        return date != null ? date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) : null;
    }
}
