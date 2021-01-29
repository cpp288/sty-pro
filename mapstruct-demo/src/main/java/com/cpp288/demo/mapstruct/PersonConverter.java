package com.cpp288.demo.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonConverter {

    PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);

    @Mappings({
            @Mapping(source = "name", target = "userName")
    })
    PersonDTO doToDto(PersonDO person);
}
