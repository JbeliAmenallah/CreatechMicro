package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.TypeDeductionDTO;
import com.PFE.Microservice.Entity.TypeDeduction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TypeDeductionMapper {
    TypeDeductionMapper INSTANCE = Mappers.getMapper(TypeDeductionMapper.class);

    @Mapping(target = "id", ignore = true)
    TypeDeduction dtoToEntity(TypeDeductionDTO typeDeductionDTO);

    TypeDeductionDTO entityToDto(TypeDeduction typeDeduction);
}
