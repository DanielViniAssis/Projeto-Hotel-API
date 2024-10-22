package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Employee;
import com.trabalho.crud.core.repository.EmployeeRepository;

@ActiveProfiles("test")
@SpringBootTest
class EmployeeServiceTest {

  @Autowired
  private EmployeeRepository repository;

  @Autowired
  private EmployeeService service;

  @BeforeEach
  void populateRepository() {
    MockitoAnnotations.openMocks(this);
    repository.save(Employee.builder().name("Employee 1").position("Gerente").build());
    repository.save(Employee.builder().name("Employee 2").position("Recepcionista").build());
    repository.save(Employee.builder().name("Employee 3").position("Auxiliar").build());
  }

  @Test
  @DisplayName("Busca todos os funcionários")
  void testBuscarTodosOsEmployees() {
    var allEmployees = service.findAll();

    assertEquals(3, allEmployees.size());
  }
}
