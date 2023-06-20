package com.prueba.backend.service;

import com.prueba.backend.exception.BusinessException;
import com.prueba.backend.model.Caso;
import com.prueba.backend.repository.CasoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CasoServiceImpl implements CasoService {

    private final CasoRepository casoRepository;

    @Override
    public List<Caso> obtenerTodos() {
        return casoRepository.findAll();
    }

    @Override
    public Caso crear(Caso caso) {
        return casoRepository.save(caso);
    }

    @Override
    public void delete(Integer id) {
        casoRepository.deleteById(id);
    }

    @Override
    public Caso actualizar(Caso caso) {
        Caso casoEncontrado = casoRepository.findById(caso.getId()).orElse(null);
        if (Objects.isNull(casoEncontrado)){
            throw new BusinessException(BusinessException.Type.CASO_NOT_FOUND);
        }
        return casoRepository.save(caso);
    }
}
