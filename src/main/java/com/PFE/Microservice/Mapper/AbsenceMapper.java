package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.AbsenceDTO;
import com.PFE.Microservice.Entity.Absence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AbsenceMapper {
    AbsenceMapper INSTANCE = Mappers.getMapper(AbsenceMapper.class);

    @Mapping(source = "dateOfAbsence", target = "dateOfAbsence")
    @Mapping(source = "reason", target = "reason")
    @Mapping(source = "contact_id", target = "contactId") // Map contact_id to contactId

    AbsenceDTO absenceToAbsenceDto(Absence absence);
}
