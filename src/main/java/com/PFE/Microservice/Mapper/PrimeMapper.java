package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.PrimeDTO;
import com.PFE.Microservice.Entity.Prime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PrimeMapper {
    PrimeMapper INSTANCE = Mappers.getMapper(PrimeMapper.class);

    @Mapping(source = "typePrimeId", target = "typePrime.id")
    @Mapping(source = "contactId", target = "contact.id")
    Prime dtoToEntity(PrimeDTO primeDTO);

    @Mapping(source = "typePrime.id", target = "typePrimeId")
    @Mapping(source = "contact.id", target = "contactId")
    PrimeDTO entityToDto(Prime prime);
}
