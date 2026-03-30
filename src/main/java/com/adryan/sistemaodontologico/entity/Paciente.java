package com.adryan.sistemaodontologico.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String sexo;
    private String telefone;
    private String email;
    private String endereco;


    private String queixaPrincipal;
    private String alergias;
    private String medicamentosEmUso;
    private String doencasSistemicas;
    private String pressaoArterial;

    private Boolean fumante;
    private Boolean diabetico;
    private Boolean hipertenso;
    private Boolean cardiopatia;
    private Boolean gravidez;

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}