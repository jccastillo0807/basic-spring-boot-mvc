package com.prueba.backend.service;

import com.prueba.backend.model.Juzgado;

import java.util.List;

public interface JuzgadoService {
    List<Juzgado> obtenerTodos();

    Juzgado crear(Juzgado juzgado);

    void delete(Integer id);

    Juzgado actualizar(Juzgado juzgado);

    List<Juzgado> buscarPorNombre(String nombre);
}
