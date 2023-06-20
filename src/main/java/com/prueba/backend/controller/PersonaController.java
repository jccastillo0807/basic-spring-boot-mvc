package com.prueba.backend.controller;

import com.prueba.backend.model.Persona;
import com.prueba.backend.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(
        origins = {"http://localhost:4200"},
        methods = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> verTodos() {
        return personaService.obtenerTodos();
    }

    @GetMapping("/{nombre}")
    public List<Persona> buscarPorNombre(@PathVariable String nombre) {
        return personaService.buscarPorNombre(nombre);
    }

    @GetMapping("/{apellido}")
    public List<Persona> buscarPorApellido(@PathVariable String apellido) {
        return personaService.buscarPorApellido(apellido);
    }

    @GetMapping("/{identificacion}")
    public Persona buscarPorIdentificacion(@PathVariable String identificacion) {
        return personaService.buscarPorIdentificacion(identificacion);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Persona crear(@Valid @RequestBody Persona persona) {
        return personaService.crear(persona);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        personaService.delete(id);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Persona update(@Valid @RequestBody Persona persona) {
        return personaService.actualizar(persona);
    }
}
