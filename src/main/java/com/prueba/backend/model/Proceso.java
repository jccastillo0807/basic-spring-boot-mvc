package com.prueba.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_PROCESOS")
public class Proceso implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NotBlank
    private String tipoTramite;

    @NotNull
    private Date fechaVencimiento;

    @NotEmpty
    @NotBlank
    private String descripcion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID")
    private Juzgado juzgado;

    private static final long serialVersionUID = 1L;
}
