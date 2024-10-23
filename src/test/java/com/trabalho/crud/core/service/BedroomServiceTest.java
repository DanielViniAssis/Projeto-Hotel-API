package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.dto.BedroomDto;
import com.trabalho.crud.core.entity.Bedroom;
import com.trabalho.crud.core.entity.BusinessException;
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
    @DisplayName("Busca Um Quarto Por Id")
    void testBuscarQuartoPorId() {
        var bedroom = service.findById(1L);
        assertNotNull(bedroom);
        assertEquals("Bedroom 1", bedroom.getNumber());
    }

    @Test
    @DisplayName("Criar Quarto")
    void testCriarQuarto() {
        BedroomDto newBedroomDto = new BedroomDto();
        newBedroomDto.setNumber("Bedroom 4");
        newBedroomDto.setType("Deluxe");

        var bedroomNew = service.save(newBedroomDto);

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
