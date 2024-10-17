package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;

import com.trabalho.crud.core.dto.EmployeesDto;
import com.trabalho.crud.core.entity.Employees;

@Mapper(componentModel = "spring")
public interface EmployeesMapper {

  Employees toEntity(EmployeesDto dto);

  EmployeesDto toDto(Employees entity);
  
}
