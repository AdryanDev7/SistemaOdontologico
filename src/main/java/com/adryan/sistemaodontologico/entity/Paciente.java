package com.adryan.sistemaodontologico.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    /**
     * Consultas do paciente. Ao excluir o paciente, consultas e procedimentos vinculados são removidos em cascata.
     */
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Consulta> consultas = new ArrayList<>();
}