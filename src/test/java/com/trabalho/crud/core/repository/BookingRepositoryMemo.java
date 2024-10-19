package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Booking;

@ActiveProfiles("test")
@Repository
public class BookingRepositoryMemo implements BookingRepository {

  private final List<Booking> bookings = new ArrayList<Booking>();

  @Override
  public List<Booking> findAll() {
    return bookings;
  }

  @Override
  public Optional<Booking> findById(Long id) {
    return bookings.stream().filter(booking -> booking.getId().equals(id)).findFirst();
  }

  @Override
  public Booking save(Booking booking) {
    var id = bookings.size() + 1;
    booking.setId((long) id);
    bookings.add(booking);
    return booking;
  }

  @Override
  public void deleteById(Long id) {
    bookings.removeIf(booking -> booking.getId() == id);
  }
}
