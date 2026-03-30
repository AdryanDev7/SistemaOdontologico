package com.adryan.sistemaodontologico.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adryan.sistemaodontologico.repository.ConsultaProcedimentoRepository;

@RestController
@RequestMapping("/financeiro")
@CrossOrigin(origins = "http://localhost:5173")
public class FinanceiroController {

	private final ConsultaProcedimentoRepository consultaProcedimentoRepository;

	public FinanceiroController(ConsultaProcedimentoRepository consultaProcedimentoRepository) {
		this.consultaProcedimentoRepository = consultaProcedimentoRepository;
	}

	@GetMapping("/estatisticas")
	public Map<String, BigDecimal> getEstatisticas() {
		LocalDate hoje = LocalDate.now();
		LocalDateTime inicioMes = hoje.withDayOfMonth(1).atStartOfDay();
		LocalDateTime inicioProximoMes = inicioMes.plusMonths(1);

		BigDecimal faturamentoMensal = consultaProcedimentoRepository.somarFaturamentoNoPeriodo(inicioMes,
				inicioProximoMes);

		return Map.of("faturamentoMensal", faturamentoMensal);
	}
}
