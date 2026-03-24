package com.adryan.sistemaodontologico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adryan.sistemaodontologico.entity.Consulta;
import com.adryan.sistemaodontologico.repository.ConsultaRepository;

@RestController
@RequestMapping("/consultas")
@CrossOrigin("*")
public class ConsultaController {

	private final ConsultaRepository repository;

	public ConsultaController(ConsultaRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Consulta> listarTodas() {
		return repository.findAll();
	}

	@PostMapping
	public Consulta agendar(@RequestBody Consulta consulta) {
		return repository.save(consulta);
	}
}