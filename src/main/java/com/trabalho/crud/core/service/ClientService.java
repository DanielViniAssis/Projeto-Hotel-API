package com.trabalho.crud.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.crud.core.dto.ClientDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.mapper.ClientMapper;
import com.trabalho.crud.core.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientService {

  private final ClientRepository repository;

  private final ClientMapper mapper;

  public List<ClientDto> findAll() {
    return repository.findAll().stream().map(client -> mapper.toDto(client)).toList();
  }

  public ClientDto findById(Long id) {
    return repository.findById(id).map(client -> mapper.toDto(client))
        .orElseThrow(() -> BusinessException.notFoundException("Cliente não encontrado"));
  }

  public ClientDto save(ClientDto clientDto) {
    var client = mapper.toEntity(clientDto);
    return mapper.toDto(repository.save(client));
  }

  public ClientDto update(Long id, ClientDto clientDto) {
    var existingClient = this.findById(id);
    clientDto.setId(existingClient.getId());
    var client = mapper.toEntity(clientDto);
    return mapper.toDto(repository.save(client));
  }

  public void deleteById(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

}
