package com.prueba.backend.service;

import com.prueba.backend.model.Caso;

import java.util.List;

public interface CasoService {
    List<Caso> obtenerTodos();

    Caso crear(Caso caso);

    void delete(Integer id);

    Caso actualizar(Caso caso);
}
