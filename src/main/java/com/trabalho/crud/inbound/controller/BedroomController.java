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

import com.trabalho.crud.core.dto.BedroomDto;
import com.trabalho.crud.core.service.BedroomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bedrooms")
public class BedroomController {

  private final BedroomService bedroomService;

  /**
   *  Retorna uma lista com todos os quartos
   * @return
  */

  @GetMapping
  public ResponseEntity<List<BedroomDto>> getAllBedrooms() {
    return ResponseEntity.ok(bedroomService.findAll());
  }
  /**
     * Realiza a busca a partir do ID do Funcionário
     * @param id id do Funcionário a ser buscado
     * @return
  */
  @GetMapping("/{id}")
  public ResponseEntity<BedroomDto> getBedroomById(@PathVariable Long id) {
    return ResponseEntity.ok(bedroomService.findById(id));
  }
  /**
     * Realiza a criação de um quarto
     * @return
     */
  @PostMapping
  public ResponseEntity<BedroomDto> createBedroom(@RequestBody BedroomDto bedroomDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bedroomService.save(bedroomDTO));
  }
  /**
   * Realiza uma atualização sobre um quarto a partir do id
   * @param id id do Quarto a ser atualizado
   * @return
   */
  @PutMapping("/{id}")
  public ResponseEntity <BedroomDto> updateBedroom(@PathVariable Long id, @RequestBody BedroomDto bedroomDTO) {
    return ResponseEntity.ok(bedroomService.update(id, bedroomDTO));
  }
  /**
   * Realiza a deleção de um quarto a partir do id
   * @param id id do Quarto a ser deletado
   * @return
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBedroom(@PathVariable Long id) {
    bedroomService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
