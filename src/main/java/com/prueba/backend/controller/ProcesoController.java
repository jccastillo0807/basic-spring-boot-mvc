package com.prueba.backend.controller;

import com.prueba.backend.model.Proceso;
import com.prueba.backend.service.ProcesoService;
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
@RequestMapping("/procesos")
@RequiredArgsConstructor
public class ProcesoController {

    private final ProcesoService procesoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Proceso> verTodos() {
        return procesoService.obtenerTodos();
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Proceso crear(@Valid @RequestBody Proceso proceso) {
        return procesoService.crear(proceso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        procesoService.delete(id);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Proceso actualizar(@Valid @RequestBody Proceso proceso) {
        return procesoService.actualizar(proceso);
    }
}
