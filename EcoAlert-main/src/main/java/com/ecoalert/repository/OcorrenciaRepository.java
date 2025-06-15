package com.ecoalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecoalert.entity.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    
}
