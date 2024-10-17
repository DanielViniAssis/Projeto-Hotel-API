package com.trabalho.crud.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.crud.core.dto.EmployeesDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.mapper.EmployeesMapper;
import com.trabalho.crud.core.repository. EmployeesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeesService {

  private final EmployeesRepository repository;

  private final EmployeesMapper mapper;

  public List<EmployeesDto> findAll() {
    return repository.findAll().stream().map(employees -> mapper.toDto(employees)).toList();
  }

  public EmployeesDto findById(Long id) {
    return repository.findById(id).map(employees -> mapper.toDto(employees))
        .orElseThrow(() -> BusinessException.notFoundException("Funcionário não encontrado"));
  }

  public EmployeesDto save(EmployeesDto employeesDto) {
    var employees = mapper.toEntity(employeesDto);
    return mapper.toDto(repository.save(employees));
  }

  public EmployeesDto update(Long id, EmployeesDto employeesDto) {
    var existingEmployees = this.findById(id);
    employeesDto.setId(existingEmployees.getId());
    var employees = mapper.toEntity(employeesDto);
    return mapper.toDto(repository.save(employees));
  }

  public void deleteById(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

}
