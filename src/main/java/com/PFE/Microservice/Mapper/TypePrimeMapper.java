package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.TypePrimeDTO;
import com.PFE.Microservice.Entity.TypePrime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TypePrimeMapper {

    TypePrimeMapper INSTANCE = Mappers.getMapper(TypePrimeMapper.class);

    @Mapping(target = "id", ignore = true)
    TypePrime dtoToEntity(TypePrimeDTO typePrimeDTO);

    TypePrimeDTO entityToDto(TypePrime typePrime);
}
