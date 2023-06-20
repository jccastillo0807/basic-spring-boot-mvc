package com.prueba.backend.controller;

import com.prueba.backend.model.Juzgado;
import com.prueba.backend.service.JuzgadoService;
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
@RequestMapping("/juzgados")
@RequiredArgsConstructor
public class JuzgadoController {

    private final JuzgadoService juzgadoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Juzgado> verTodos() {
        return juzgadoService.obtenerTodos();
    }

    @GetMapping("/{nombre}")
    public List<Juzgado> buscarPorNombre(@PathVariable String nombre) {
       return juzgadoService.buscarPorNombre(nombre);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Juzgado crear(@Valid @RequestBody Juzgado juzgado) {
        return juzgadoService.crear(juzgado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        juzgadoService.delete(id);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Juzgado actualizar(@Valid @RequestBody Juzgado juzgado) {
        return juzgadoService.actualizar(juzgado);
    }
}
