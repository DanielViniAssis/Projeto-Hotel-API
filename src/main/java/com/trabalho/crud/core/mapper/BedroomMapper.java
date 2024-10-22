package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;

import com.trabalho.crud.core.dto.BedroomDto;
import com.trabalho.crud.core.entity.Bedroom;

@Mapper(componentModel = "spring")
public interface BedroomMapper {
    Bedroom toEntity(BedroomDto dto);
    BedroomDto toDto(Bedroom entity);
}
