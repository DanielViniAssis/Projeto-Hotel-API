package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;

import com.trabalho.crud.core.dto.BookingDto;
import com.trabalho.crud.core.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {

  Booking toEntity(BookingDto dto);

  BookingDto toDto(Booking entity);
  
}
