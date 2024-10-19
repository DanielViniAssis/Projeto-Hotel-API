package com.trabalho.crud.inbound.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.crud.core.dto.EmployeeDto;
import com.trabalho.crud.core.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  /**
   * Retorna uma lista com todos os Funcionários
   * 
   * @return
   */

  @GetMapping
  public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
    return ResponseEntity.ok(employeeService.findAll());
  }

  /**
   * Realiza a busca a partir do ID do Funcionário
   * 
   * @param id id do Funcionário a ser buscado
   * @return
   */
  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
    return ResponseEntity.ok(employeeService.findById(id));
  }

  /**
   * Realiza a criação de um Funcionário
   * 
   * @return
   */
  @PostMapping
  public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeDTO));
  }

  /**
   * Realiza uma atualização de um Funcionário a partir do ID
   * 
   * @param id id do Funcionário a ser alterado
   * @return
   */
  @PutMapping("/{id}")
  public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDTO) {
    return ResponseEntity.ok(employeeService.update(id, employeeDTO));
  }

  /**
   * Realiza a deleção de um Funcionário a partir do ID
   * 
   * @param id id do Funcionário a ser deletado
   * @return
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    employeeService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
