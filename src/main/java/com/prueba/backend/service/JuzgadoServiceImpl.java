package com.prueba.backend.service;

import com.prueba.backend.exception.BusinessException;
import com.prueba.backend.model.Juzgado;
import com.prueba.backend.repository.JuzgadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class JuzgadoServiceImpl implements JuzgadoService {

    private final JuzgadoRepository juzgadoRepository;

    @Override
    public List<Juzgado> obtenerTodos() {
        return juzgadoRepository.findAll();
    }

    @Override
    public Juzgado crear(Juzgado juzgado) {
        return juzgadoRepository.save(juzgado);
    }

    @Override
    public void delete(Integer id) {
        juzgadoRepository.deleteById(id);
    }

    @Override
    public Juzgado actualizar(Juzgado juzgado) {
        Juzgado juzgadoEncontrado = juzgadoRepository.findById(juzgado.getId()).orElse(null);
        if (Objects.isNull(juzgadoEncontrado)){
            throw new BusinessException(BusinessException.Type.JUZGADO_NOT_FOUND);
        }
        return juzgadoRepository.save(juzgado);
    }

    @Override
    public List<Juzgado> buscarPorNombre(String nombre) {
        return juzgadoRepository.findByNombre(nombre);
    }
}
