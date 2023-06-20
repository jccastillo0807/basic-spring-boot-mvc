package com.prueba.backend.repository;

import com.prueba.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByPersonaId(Integer id);
}
