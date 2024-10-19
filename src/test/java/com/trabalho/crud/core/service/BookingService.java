package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Booking;
import com.trabalho.crud.core.repository.BookingRepository;

@ActiveProfiles("test")
@SpringBootTest
class BookingServiceTest {

  @Autowired
  private BookingRepository repository;

  @Autowired
  private BookingService service;

  @BeforeEach
  void populateRepository() {
    MockitoAnnotations.openMocks(this);
    repository.save(Booking.builder().checkIn("19-10-2024").checkOut("23-10-2024").paymentMethod("Credit Card").clientName("Davi 1").clientEmail("teste@test.com").bedroomNumber("12").bedroomType("Suite").employeeName("Jairo").employeePosition("Gerente").build());
  }

  @Test
  @DisplayName("Busca todas as reservas")
  void testBuscarTodosOsBedrooms() {
    var allBookings = service.findAll();

    assertEquals(3, allBookings.size());
  }
}
