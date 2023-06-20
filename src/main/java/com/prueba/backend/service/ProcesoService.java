package com.prueba.backend.service;

import com.prueba.backend.model.Proceso;

import java.util.List;

public interface ProcesoService {
    List<Proceso> obtenerTodos();

    Proceso crear(Proceso proceso);

    void delete(Integer id);

    Proceso actualizar(Proceso proceso);
}
