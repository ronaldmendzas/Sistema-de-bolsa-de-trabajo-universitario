package com.ProyectoFinal.Trabajo_U.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocenteDTO {
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

    private String gradoAcademico;
    private String areaEspecialidad;
}
