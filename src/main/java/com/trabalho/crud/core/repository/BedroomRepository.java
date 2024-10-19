package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import com.trabalho.crud.core.entity.Bedroom;

public interface BedroomRepository {

  List<Bedroom> findAll();

  Optional<Bedroom> findById(Long id);

  Bedroom save(Bedroom bedroom);

  void deleteById(Long id);
}
