package com.prueba.backend.repository;

import com.prueba.backend.model.Caso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoRepository extends JpaRepository<Caso, Integer> {
}
