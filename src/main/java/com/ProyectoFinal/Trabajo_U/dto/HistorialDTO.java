package com.ProyectoFinal.Trabajo_U.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorialDTO {

    private Long id;
    private Long personaId;
    private Long convocatoriaId;
    private String estadoFinal;
    private LocalDate fechaResolucion;
    private String observaciones;
    private Integer version;

}
