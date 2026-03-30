package com.adryan.sistemaodontologico.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adryan.sistemaodontologico.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
	long countByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}