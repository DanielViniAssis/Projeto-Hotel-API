package com.trabalho.crud.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.crud.core.dto.BookingDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.mapper.BookingMapper;
import com.trabalho.crud.core.repository. BookingRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingService {

  private final BookingRepository repository;

  private final BookingMapper mapper;

  public List<BookingDto> findAll() {
    return repository.findAll().stream().map(booking -> mapper.toDto(booking)).toList();
  }

  public BookingDto findById(Long id) {
    return repository.findById(id).map(booking -> mapper.toDto(booking))
        .orElseThrow(() -> BusinessException.notFoundException("Reserva não encontrada"));
  }

  public BookingDto save(BookingDto bookingDto) {
    var booking = mapper.toEntity(bookingDto);
    return mapper.toDto(repository.save(booking));
  }

  public BookingDto update(Long id, BookingDto bookingDto) {
    var existingBooking = this.findById(id);
    bookingDto.setId(existingBooking.getId());
    var booking = mapper.toEntity(bookingDto);
    return mapper.toDto(repository.save(booking));
  }

  public void deleteById(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

}
