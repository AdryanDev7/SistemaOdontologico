package com.adryan.sistemaodontologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adryan.sistemaodontologico.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}