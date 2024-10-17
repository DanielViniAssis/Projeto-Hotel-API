package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.crud.core.entity.Employees;
import com.trabalho.crud.core.repository.EmployeesRepository;

@Profile("!test")
public interface JpaEmployeesRepository  extends EmployeesRepository, JpaRepository<Employees, Long> {
}
