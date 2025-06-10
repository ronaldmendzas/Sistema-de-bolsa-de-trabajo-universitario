package com.ProyectoFinal.Trabajo_U.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstudianteDTO {
    private Long id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String ci;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String correo;
    private String ciudad;
    private String telefono;

    private String carrera;
    private String matricula;
    private int nivel;
}
