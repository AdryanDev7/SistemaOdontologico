package com.adryan.sistemaodontologico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adryan.sistemaodontologico.entity.Paciente;
import com.adryan.sistemaodontologico.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

	private final PacienteRepository repository;

	public PacienteController(PacienteRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Paciente> listarTodos() {
		return repository.findAll();
	}

	@PostMapping
	public Paciente cadastrar(@RequestBody Paciente novoPaciente) {
		return repository.save(novoPaciente);
	}
}