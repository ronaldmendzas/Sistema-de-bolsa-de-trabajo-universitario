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
@Table(name = "docente")
public class Docente extends Persona {

    @Column(name = "grado_academico", nullable = false, length = 100)
    private String gradoAcademico;

    @Column(name = "area_especialidad", nullable = false, length = 100)
    private String areaEspecialidad;

}