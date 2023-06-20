package com.prueba.backend.service;

import com.prueba.backend.exception.BusinessException;
import com.prueba.backend.model.Cliente;
import com.prueba.backend.model.Persona;
import com.prueba.backend.model.Testigo;
import com.prueba.backend.repository.ClienteRepository;
import com.prueba.backend.repository.PersonaRepository;
import com.prueba.backend.repository.TestigoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final ClienteRepository clienteRepository;
    private final TestigoRepository testigoRepository;

    @Override
    public List<Persona> obtenerTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Persona crear(Persona persona) {
        Persona personaEncontrada = buscarPorIdentificacion(persona.getNumeroDocumento());
        if (Objects.nonNull(personaEncontrada)) {
            throw new BusinessException(BusinessException.Type.PERSONA_ALREADY_EXISTS);
        }

        Persona personaACrear = personaRepository.save(persona);
        if (personaACrear.getTestigo().equals(true)) {
            Testigo testigoACrear = Testigo.builder().persona(personaACrear).build();
            testigoRepository.save(testigoACrear);
        }
        if (personaACrear.getCliente().equals(true)) {
            Cliente clienteACrear = Cliente.builder().persona(personaACrear).build();
            clienteRepository.save(clienteACrear);
        }
        return personaACrear;
    }

    @Override
    public void delete(Integer id) {
        Persona personaEncontrada = personaRepository.getById(id);
        if (personaEncontrada.getCliente().equals(true)) {
            Cliente clienteEncontrado = clienteRepository.findByPersonaId(id);
            clienteRepository.delete(clienteEncontrado);
        }

        if (personaEncontrada.getTestigo().equals(true)) {
            Testigo testigoEncontrado = testigoRepository.findByPersonaId(id);
            testigoRepository.delete(testigoEncontrado);
        }
        personaRepository.deleteById(id);
    }

    @Override
    public Persona actualizar(@Valid @RequestBody Persona persona) {
        Persona personaEncontrada = personaRepository.findById(persona.getId()).orElse(null);
        if (Objects.isNull(personaEncontrada)) {
            throw new BusinessException(BusinessException.Type.PERSONA_NOT_FOUND);
        }
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> buscarPorNombre(String nombre) {
        return personaRepository.findByPrimerNombre(nombre);
    }

    @Override
    public List<Persona> buscarPorApellido(String apellido) {
        return personaRepository.findByPrimerApellido(apellido);
    }

    @Override
    public Persona buscarPorIdentificacion(String identificacion) {
        return personaRepository.findByNumeroDocumento(identificacion);
    }

}
