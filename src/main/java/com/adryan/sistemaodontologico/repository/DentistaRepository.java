package com.adryan.sistemaodontologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adryan.sistemaodontologico.entity.Dentista;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}