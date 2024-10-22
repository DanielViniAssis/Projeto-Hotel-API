package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.crud.core.entity.Booking;
import com.trabalho.crud.core.repository.BookingRepository;

@Profile("!test")
public interface JpaBookingRepository  extends BookingRepository, JpaRepository<Booking, Long> {
}
