package com.adryan.sistemaodontologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adryan.sistemaodontologico.entity.ConsultaProcedimento;

@Repository
public interface ConsultaProcedimentoRepository extends JpaRepository<ConsultaProcedimento, Long> {
}