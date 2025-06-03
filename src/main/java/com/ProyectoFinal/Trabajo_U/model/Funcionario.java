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
@Table(name = "funcionario")
public class Funcionario extends Persona {

    @Column(nullable = false, length = 100)
    private String cargo; // Ej: Secretaria, Encargado, etc.

    @Column(nullable = false, length = 100)
    private String unidad; // Ej: ITIC, Kardex, Dirección Administrativa, etc.

}