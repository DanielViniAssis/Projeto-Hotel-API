package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.crud.core.entity.Bedroom;
import com.trabalho.crud.core.repository.BedroomRepository;

@Profile("!test")
public interface JpaBedroomRepository  extends BedroomRepository, JpaRepository<Bedroom, Long> {
}
