package com.adryan.sistemaodontologico.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa PathVariable, PutMapping, etc.
import com.adryan.sistemaodontologico.entity.Paciente;
import com.adryan.sistemaodontologico.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:5175")
public class PacienteController {

	private final PacienteRepository repository;

	public PacienteController(PacienteRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Paciente> listarTodos() {
		return repository.findAll();
	}

	@GetMapping("/estatisticas")
	public Map<String, Long> estatisticas() {
		return Map.of("totalPacientes", repository.count());
	}

	@PostMapping
	public Paciente cadastrar(@RequestBody Paciente novoPaciente) {
		return repository.save(novoPaciente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @RequestBody Paciente dados) {
		return repository.findById(id)
				.map(p -> {
					// Dados Pessoais
					p.setNome(dados.getNome());
					p.setCpf(dados.getCpf());
					p.setRg(dados.getRg());
					p.setDataNascimento(dados.getDataNascimento());
					p.setSexo(dados.getSexo());
					p.setTelefone(dados.getTelefone());
					p.setEmail(dados.getEmail());
					p.setEndereco(dados.getEndereco());

					// Anamnese / Saúde
					p.setQueixaPrincipal(dados.getQueixaPrincipal());
					p.setAlergias(dados.getAlergias());
					p.setMedicamentosEmUso(dados.getMedicamentosEmUso());
					p.setDoencasSistemicas(dados.getDoencasSistemicas());
					p.setPressaoArterial(dados.getPressaoArterial());
					p.setFumante(dados.getFumante());
					p.setDiabetico(dados.getDiabetico());
					p.setHipertenso(dados.getHipertenso());
					p.setCardiopatia(dados.getCardiopatia());
					p.setGravidez(dados.getGravidez());
					p.setObservacoes(dados.getObservacoes());

					Paciente atualizado = repository.save(p);
					return ResponseEntity.ok(atualizado);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}