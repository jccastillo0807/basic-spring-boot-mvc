package com.prueba.backend.service;

import com.prueba.backend.model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> obtenerTodos();

    Persona crear(Persona persona);

    void delete(Integer id);

    Persona actualizar(Persona persona);

    List<Persona>  buscarPorNombre(String nombre);

    List<Persona> buscarPorApellido(String apellido);

    Persona buscarPorIdentificacion(String identificacion);
}
