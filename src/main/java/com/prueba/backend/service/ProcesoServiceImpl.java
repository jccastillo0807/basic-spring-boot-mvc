package com.prueba.backend.service;

import com.prueba.backend.exception.BusinessException;
import com.prueba.backend.model.Proceso;
import com.prueba.backend.repository.ProcesoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProcesoServiceImpl implements ProcesoService{

    private final ProcesoRepository procesoRepository;

    @Override
    public List<Proceso> obtenerTodos() {
        return procesoRepository.findAll();
    }

    @Override
    public Proceso crear(Proceso proceso) {
        return procesoRepository.save(proceso);
    }

    @Override
    public void delete(Integer id) {
procesoRepository.deleteById(id);
    }

    @Override
    public Proceso actualizar(Proceso proceso) {
        Proceso procesoEncontrado = procesoRepository.findById(proceso.getId()).orElse(null);
        if (Objects.isNull(procesoEncontrado)){
            throw new BusinessException(BusinessException.Type.PROCESO_NOT_FOUND);
        }
        return procesoRepository.save(proceso);
    }
}
