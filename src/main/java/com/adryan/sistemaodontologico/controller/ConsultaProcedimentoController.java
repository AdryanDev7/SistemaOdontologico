package com.adryan.sistemaodontologico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adryan.sistemaodontologico.entity.ConsultaProcedimento;
import com.adryan.sistemaodontologico.repository.ConsultaProcedimentoRepository;

@RestController
@RequestMapping("/itens-consulta")
@CrossOrigin("*")
public class ConsultaProcedimentoController {

	private final ConsultaProcedimentoRepository repository;

	public ConsultaProcedimentoController(ConsultaProcedimentoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<ConsultaProcedimento> listarItens() {
		return repository.findAll();
	}

	@PostMapping
	public ConsultaProcedimento adicionarItem(@RequestBody ConsultaProcedimento item) {
		return repository.save(item);
	}
}