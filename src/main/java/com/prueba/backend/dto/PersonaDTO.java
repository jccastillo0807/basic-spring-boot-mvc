package com.prueba.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaDTO {

    @NotNull
    private Integer id;

    @NotEmpty
    private String tipoDocumento;

    @NotEmpty
    private String numeroDocumento;

    @NotEmpty
    private String primerNombre;


    private String segundoNombre;

    @NotEmpty
    private String primerApellido;

    private String segundoApellido;

    @NotEmpty
    private String ciudad;

    @NotEmpty
    private String direccion;

    private String telefono;

    private String celular;

    @NotNull
    private Boolean testigo;

    @NotNull
    private Boolean cliente;

    @NotNull
    private Date fechaNacimiento;

    private static final long serialVersionUID = 1L;
}
