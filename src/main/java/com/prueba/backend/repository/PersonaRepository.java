package com.prueba.backend.repository;

import com.prueba.backend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByPrimerNombre(String nombre);

    List<Persona> findByPrimerApellido(String apellido);

    Persona findByNumeroDocumento(String identificacion);
}
