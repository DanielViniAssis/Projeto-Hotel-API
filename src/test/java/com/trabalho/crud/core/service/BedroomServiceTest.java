package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Bedroom;
import com.trabalho.crud.core.repository.BedroomRepository;

@ActiveProfiles("test")
@SpringBootTest
class BedroomServiceTest {

  @Autowired
  private BedroomRepository repository;

  @Autowired
  private BedroomService service;

  @BeforeEach
  void populateRepository() {
    MockitoAnnotations.openMocks(this);
    repository.save(Bedroom.builder().number("Bedroom 1").type("Suíte").build());
    repository.save(Bedroom.builder().number("Bedroom 2").type("Individual").build());
    repository.save(Bedroom.builder().number("Bedroom 3").type("Suíte presidencial").build());
  }

  @Test
  @DisplayName("Busca todos os quartos")
  void testBuscarTodosOsBedrooms() {
    var allBedrooms = service.findAll();

    assertEquals(3, allBedrooms.size());
  }
}
