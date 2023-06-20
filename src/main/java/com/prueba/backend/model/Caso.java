package com.prueba.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_CASOS")
public class Caso implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_TESTIGO", referencedColumnName = "ID")
    private Testigo testigo;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_JUZGADO", referencedColumnName = "ID")
    private Juzgado juzgado;

    private static final long serialVersionUID = 1L;
}
