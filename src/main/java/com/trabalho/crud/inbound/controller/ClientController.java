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

import com.trabalho.crud.core.dto.ClientDto;
import com.trabalho.crud.core.service.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientService clientService;

  /**
   * Retorna uma lista com todos os Clientes
   * 
   * @return Clientes correspondentes
   */

  @GetMapping
  public ResponseEntity<List<ClientDto>> getAllClients() {
    return ResponseEntity.ok(clientService.findAll());
  }

  /**
   * Realiza a busca a partir do ID do Cliente
   * 
   * @param id id do Cliente a ser buscado
   * @return Cliente Correspondente
   */
  @GetMapping("/{id}")
  public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
    return ResponseEntity.ok(clientService.findById(id));
  }

  /**
   * Realiza a criação de um Cliente
   * 
   * @return Cliente Criado
   */
  @PostMapping
  public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientDTO));
  }

  /**
   * Realiza uma atualização em um cliente a partir do id
   * 
   * @param id id do Cliente a ser alterado
   * @return Cliente Atualizado
   */
  @PutMapping("/{id}")
  public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDTO) {
    return ResponseEntity.ok(clientService.update(id, clientDTO));
  }

  /**
   * Realiza a deleção de um cliente a partir do ID
   * 
   * @param id id do Cliente a ser deletado
   * @return Cliente Deletado
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    clientService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
