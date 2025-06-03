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
public class DocumentosDTO {
    private Long id;
    private String nombreArchivo;
    private String tipo;
    private String descripcion;
    private byte[] contenido;
    private LocalDate fechaSubida;

    private Long personaId;
}
