package com.prueba.backend.repository;

import com.prueba.backend.model.Proceso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcesoRepository extends JpaRepository<Proceso, Integer> {
}
