package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import com.trabalho.crud.core.entity.Employees;

public interface EmployeesRepository {

  List<Employees> findAll();

  Optional<Employees> findById(Long id);

  Employees save(Employees employees);

  void deleteById(Long id);
}
