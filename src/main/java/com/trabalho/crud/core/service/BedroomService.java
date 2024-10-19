package com.trabalho.crud.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.crud.core.dto.BedroomDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.mapper.BedroomMapper;
import com.trabalho.crud.core.repository. BedroomRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BedroomService {

  private final BedroomRepository repository;

  private final BedroomMapper mapper;

  public List<BedroomDto> findAll() {
    return repository.findAll().stream().map(bedroom -> mapper.toDto(bedroom)).toList();
  }

  public BedroomDto findById(Long id) {
    return repository.findById(id).map(bedroom -> mapper.toDto(bedroom))
        .orElseThrow(() -> BusinessException.notFoundException("Quarto não encontrado"));
  }

  public BedroomDto save(BedroomDto bedroomDto) {
    var bedroom = mapper.toEntity(bedroomDto);
    return mapper.toDto(repository.save(bedroom));
  }

  public BedroomDto update(Long id, BedroomDto bedroomDto) {
    var existingBedroom = this.findById(id);
    bedroomDto.setId(existingBedroom.getId());
    var bedroom = mapper.toEntity(bedroomDto);
    return mapper.toDto(repository.save(bedroom));
  }

  public void deleteById(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

}
