package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import com.trabalho.crud.core.entity.Booking;

public interface BookingRepository {

  List<Booking> findAll();

  Optional<Booking> findById(Long id);

  Booking save(Booking booking);

  void deleteById(Long id);
}
