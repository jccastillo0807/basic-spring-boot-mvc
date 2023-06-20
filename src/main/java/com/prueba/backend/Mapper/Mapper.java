package com.prueba.backend.Mapper;

import com.prueba.backend.dto.PersonaDTO;
import com.prueba.backend.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private Mapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Persona convertirPersonaDtoAPersona(PersonaDTO personaDTO) {
        return Persona.builder()
                .id(personaDTO.getId())
                .tipoDocumento(personaDTO.getTipoDocumento())
                .numeroDocumento(personaDTO.getNumeroDocumento())
                .primerNombre(personaDTO.getPrimerNombre())
                .segundoNombre(personaDTO.getSegundoNombre())
                .primerApellido(personaDTO.getPrimerApellido())
                .segundoApellido(personaDTO.getSegundoApellido())
                .ciudad(personaDTO.getCiudad())
                .direccion(personaDTO.getDireccion())
                .telefono(personaDTO.getTelefono())
                .celular(personaDTO.getCelular())
                .fechaNacimiento(personaDTO.getFechaNacimiento())
                .testigo(personaDTO.getTestigo())
                .cliente(personaDTO.getCliente())
                .build();
    }

    public static PersonaDTO convertirPersonaAPersonaDto(Persona persona) {
        return PersonaDTO.builder()
                .id(persona.getId())
                .tipoDocumento(persona.getTipoDocumento())
                .numeroDocumento(persona.getNumeroDocumento())
                .primerNombre(persona.getPrimerNombre())
                .segundoNombre(persona.getSegundoNombre())
                .primerApellido(persona.getPrimerApellido())
                .segundoApellido(persona.getSegundoApellido())
                .ciudad(persona.getCiudad())
                .direccion(persona.getDireccion())
                .telefono(persona.getTelefono())
                .celular(persona.getCelular())
                .fechaNacimiento(persona.getFechaNacimiento())
                .testigo(persona.getTestigo())
                .cliente(persona.getCliente())
                .build();
    }

    public static List<PersonaDTO> listaPersonaAListaPersonaDTO(List<Persona> personaList) {
        List<PersonaDTO> personaDTOList = new ArrayList<>();
        personaList.forEach(
                persona -> personaDTOList.add(convertirPersonaAPersonaDto(persona))
        );

        return personaDTOList;
    }
}
