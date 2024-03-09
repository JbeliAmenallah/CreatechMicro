package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.CotisationDTO;
import com.PFE.Microservice.Entity.Cotisation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CotisationMapper {

    CotisationMapper INSTANCE = Mappers.getMapper(CotisationMapper.class);

    @Mapping(source = "libele", target = "libele")
    @Mapping(source = "taux", target = "taux")
    @Mapping(source = "annee", target = "annee")
    @Mapping(source = "contact.name", target = "contactName") // Map contact.name to contactName
    CotisationDTO cotisationToCotisationDto(Cotisation cotisation);

    @Mapping(source = "libele", target = "libele")
    @Mapping(source = "taux", target = "taux")
    @Mapping(source = "annee", target = "annee")
    @Mapping(source = "contactName", target = "contact") // Map contactName to contact
    Cotisation cotisationDtoToCotisation(CotisationDTO cotisationDTO);
}
