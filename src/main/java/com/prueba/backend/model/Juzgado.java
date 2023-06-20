package com.prueba.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_JUZGADOS")
public class Juzgado implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "NOMBRE")
    private String nombre;

    @NotEmpty
    @Column(name = "DIRECION")
    private String direccion;

    @NotEmpty
    @Column(name = "TELEFONO")
    private String telefono;

    private static final long serialVersionUID = 1L;
}
