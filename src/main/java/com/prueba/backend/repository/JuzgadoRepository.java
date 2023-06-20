package com.prueba.backend.repository;

import com.prueba.backend.model.Juzgado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JuzgadoRepository extends JpaRepository<Juzgado, Integer> {
    List<Juzgado> findByNombre(String nombre);
}
