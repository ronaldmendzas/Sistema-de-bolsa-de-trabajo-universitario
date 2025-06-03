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
public class PostulacionDTO {
    private Long id;
    private LocalDate fechaPostulacion;
    private String estado;
    private Long personaId;
    private Long convocatoriaId;
}
