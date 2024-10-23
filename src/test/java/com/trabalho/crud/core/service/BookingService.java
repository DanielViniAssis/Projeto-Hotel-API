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

    assertEquals(1, allBookings.size());
  }

  
  @Test
  @DisplayName("Criar Reserva")
  void testCriarQuarto() {
      BookingtoDTO newBookingtoDTO = new BookingtoDTO();
      newBookingtoDTO.setCheckIn("10-09-2024");
      newBookingtoDTO.setCheckOut("10-10-2024");
      newBookingtoDTO.setPayMethod("Credit Card");
      newBookingtoDTO.setClientName("Jairo");
      newBookingtoDTO.setClientEmail("jairo@test");

      var bedroomNew = service.save(newBookingtoDTO);

      assertNotNull(bedroomNew);
      assertEquals("Bedroom 4", bedroomNew.getNumber());
  }

  @Test
  @DisplayName("Atualizar Quarto")
  void testAtualizarQuarto() {
      var existingBedroom = repository.findAll().get(0);
      assertNotNull(existingBedroom);

      BedroomDto updatedBedroomDto = new BedroomDto();
      updatedBedroomDto.setId(existingBedroom.getId());
      updatedBedroomDto.setNumber("Bedroom 1 Updated");
      updatedBedroomDto.setType("Suíte Atualizada");

      var updatedBedroom = service.update(existingBedroom.getId(), updatedBedroomDto);

      assertNotNull(updatedBedroom);
      assertEquals("Bedroom 1 Updated", updatedBedroom.getNumber());
  }

  @Test
  @DisplayName("Buscar Quarto Inexistente")
  void testBuscarQuartoInexistente() {
      assertThrows(BusinessException.class, () -> {
          service.findById(999L); // Assuming 999 does not exist
      });
  }


}
