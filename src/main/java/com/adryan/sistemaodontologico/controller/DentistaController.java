package com.adryan.sistemaodontologico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adryan.sistemaodontologico.entity.Dentista;
import com.adryan.sistemaodontologico.repository.DentistaRepository;

@RestController
@RequestMapping("/dentistas")
@CrossOrigin("*")
public class DentistaController {

    private final DentistaRepository repository;

    public DentistaController(DentistaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Dentista> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Dentista cadastrar(@RequestBody Dentista dentista) {
        return repository.save(dentista);
    }
}