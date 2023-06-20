package com.prueba.backend.repository;

import com.prueba.backend.model.Testigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestigoRepository extends JpaRepository<Testigo, Integer> {
    Testigo findByPersonaId(Integer id);
}
