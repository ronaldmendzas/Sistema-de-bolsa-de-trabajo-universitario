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
public class ConvocatoriasDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaPublicacion;
    private LocalDate fechaCierre;
}
