package com.adryan.sistemaodontologico.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.adryan.sistemaodontologico.entity.ConsultaProcedimento;

@Repository
public interface ConsultaProcedimentoRepository extends JpaRepository<ConsultaProcedimento, Long> {
	@Query("""
			select coalesce(sum(cp.valorCobrado), 0)
			from ConsultaProcedimento cp
			where cp.consulta.dataHora >= :inicio and cp.consulta.dataHora < :fim
			""")
	BigDecimal somarFaturamentoNoPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}