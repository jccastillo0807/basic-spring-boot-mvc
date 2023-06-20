package com.prueba.backend.controller;

import com.prueba.backend.model.Caso;
import com.prueba.backend.service.CasoService;
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
@RequestMapping("/casos")
@RequiredArgsConstructor
public class CasoController {

    private final CasoService casoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Caso> verTodos() {
        return casoService.obtenerTodos();
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Caso crear(@Valid @RequestBody Caso caso) {
        return casoService.crear(caso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        casoService.delete(id);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Caso actualizar(@Valid @RequestBody Caso caso) {
        return casoService.actualizar(caso);
    }
}
