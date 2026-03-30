package com.adryan.sistemaodontologico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adryan.sistemaodontologico.entity.Procedimento;
import com.adryan.sistemaodontologico.repository.ProcedimentoRepository;

@RestController
@RequestMapping("/procedimentos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProcedimentoController {

	private final ProcedimentoRepository repository;

	public ProcedimentoController(ProcedimentoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Procedimento> listarTodos() {
		return repository.findAll();
	}

	@PostMapping
	public Procedimento cadastrar(@RequestBody Procedimento procedimento) {
		return repository.save(procedimento);
	}
}