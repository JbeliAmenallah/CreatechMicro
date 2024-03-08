package com.PFE.Microservice.Mapper;

import com.PFE.Microservice.DTO.AbsenceDTO;
import com.PFE.Microservice.DTO.ContactDTO;
import com.PFE.Microservice.Entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "mailAddress", target = "mailAddress")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "degree", target = "degree")
    @Mapping(source = "id", target = "id")
    AbsenceDTO contactToContactDto(Contact contact);


}

