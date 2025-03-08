package com.pichincha.customer.application.mapper;

import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import com.pichincha.customer.application.domain.dto.CustomerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerEntity toEntity(CustomerDTO dto);
    CustomerDTO toDTO(CustomerEntity entity);

    List<CustomerDTO> toDTOList(List<CustomerEntity> list);
}
