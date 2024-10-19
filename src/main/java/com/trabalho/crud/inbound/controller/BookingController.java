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

import com.trabalho.crud.core.dto.BookingDto;
import com.trabalho.crud.core.service.BookingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bookings")
public class BookingController {

  private final BookingService bookingService;

  /**
   * Retorna uma lista de todas as reservas
   * @return
   */

  @GetMapping
  public ResponseEntity<List<BookingDto>> getAllBookings() {
    return ResponseEntity.ok(bookingService.findAll());
  }
  /**
     * Realiza a busca a partir do ID da reserva
     * @param id id da reserva a ser buscada
     * @return
     */
  @GetMapping("/{id}")
  public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) {
    return ResponseEntity.ok(bookingService.findById(id));
  }
  /**
   * Realiza a criação de uma reserva
   * @return
   */
  @PostMapping
  public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(bookingDTO));
  }
  /**
   * Realiza uma atualização de uma reserva a partir do id
   * @param id id da reserva a ser alterada
   * @return
   */
  @PutMapping("/{id}")
  public ResponseEntity <BookingDto> updateBooking(@PathVariable Long id, @RequestBody BookingDto bookingDTO) {
    return ResponseEntity.ok(bookingService.update(id, bookingDTO));
  }
  /**
   * Realiza a deleção de uma reserva a partir do id
   * @param id id da reserva a ser deletada
   * @return
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
    bookingService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
