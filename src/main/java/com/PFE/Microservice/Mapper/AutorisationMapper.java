package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.AutorisationDTO;
import com.PFE.Microservice.Entity.Autorisation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutorisationMapper {

    AutorisationMapper INSTANCE = Mappers.getMapper(AutorisationMapper.class);

    @Mapping(source = "date", target = "date")
    @Mapping(source = "contact.name", target = "contactName") // Map contact.name to contactName
    AutorisationDTO autorisationToAutorisationDto(Autorisation autorisation);

    @Mapping(source = "date", target = "date")
    @Mapping(source = "contactName", target = "contact") // Map contactName to contact
    Autorisation autorisationDtoToAutorisation(AutorisationDTO autorisationDTO);
}
