package com.prueba.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_PERSONAS")
public class Persona implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "TIPO_IDENTIFICACION")
    private String tipoDocumento;

    @NotEmpty
    @Column(name = "NUMERO_IDENTIFICACION", unique = true)
    private String numeroDocumento;

    @NotEmpty
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;

    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;

    @NotEmpty
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;

    @NotEmpty
    @Column(name = "CIUDAD")
    private String ciudad;

    @NotEmpty
    @Column(name = "DIRECION")
    private String direccion;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "CELULAR")
    private String celular;

    @Column(name = "ES_TESTIGO")
    private Boolean testigo;

    @Column(name = "ES_CLIENTE")
    private Boolean cliente;

    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    private static final long serialVersionUID = 1L;
}
