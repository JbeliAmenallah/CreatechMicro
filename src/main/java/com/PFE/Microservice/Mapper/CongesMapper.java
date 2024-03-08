package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.CongesDTO;
import com.PFE.Microservice.Entity.Conges;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CongesMapper {
    CongesMapper INSTANCE = Mappers.getMapper(CongesMapper.class);

    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "contact.id", target = "contactId") // Map contact.id to contactId

    CongesDTO congesToCongesDto(Conges conges);

    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "contactId", target = "contact") // Map contactId to contact

    Conges congesDtoToConges(CongesDTO congesDTO);
}
