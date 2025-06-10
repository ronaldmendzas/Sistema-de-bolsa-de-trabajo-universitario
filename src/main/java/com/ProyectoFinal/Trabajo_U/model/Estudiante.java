package com.ProyectoFinal.Trabajo_U.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "estudiante")
public class Estudiante extends Persona {

    @Column(nullable = false, length = 100)
    private String carrera;

    @Column(nullable = false, length = 50)
    private String matricula;

    @Column(nullable = false)
    private int nivel;

}
