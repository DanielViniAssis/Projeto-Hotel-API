package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Bedroom;

@ActiveProfiles("test")
@Repository
public class BedroomRepositoryMemo implements BedroomRepository {

  private final List<Bedroom> bedrooms = new ArrayList<Bedroom>();

  @Override
  public List<Bedroom> findAll() {
    return bedrooms;
  }

  @Override
  public Optional<Bedroom> findById(Long id) {
    return bedrooms.stream().filter(bedroom -> bedroom.getId().equals(id)).findFirst();
  }

  @Override
  public Bedroom save(Bedroom bedroom) {
    var id = bedrooms.size() + 1;
    bedroom.setId((long) id);
    bedrooms.add(bedroom);
    return bedroom;
  }

  @Override
  public void deleteById(Long id) {
    bedrooms.removeIf(bedroom -> bedroom.getId() == id);
  }
}
