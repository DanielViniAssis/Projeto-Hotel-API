package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Employees;

@ActiveProfiles("test")
@Repository
public class EmployeesRepositoryMemo implements EmployeesRepository {

  private final List<Employees> employees = new ArrayList<Employees>();

  @Override
  public List<Employees> findAll() {
    return employees;
  }

  @Override
  public Optional<Employees> findById(Long id) {
    return employees.stream().filter(client -> client.getId().equals(id)).findFirst();
  }

  @Override
  public Client save(Client client) {
    var id = clients.size() + 1;
    client.setId((long) id);
    clients.add(client);
    return client;
  }

  @Override
  public void deleteById(Long id) {
    clients.removeIf(client -> client.getId() == id);
  }
}
