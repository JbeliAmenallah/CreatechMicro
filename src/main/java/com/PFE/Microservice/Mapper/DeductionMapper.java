package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.DeductionDTO;
import com.PFE.Microservice.Entity.Deduction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DeductionMapper {
    DeductionMapper INSTANCE = Mappers.getMapper(DeductionMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contact.id", source = "contactId") // Map contactId to contact.id
    Deduction dtoToEntity(DeductionDTO deductionDTO);

    @Mapping(target = "contactId", source = "contact.id") // Map contact.id to contactId
    DeductionDTO entityToDto(Deduction deduction);
}
