package com.ProyectoFinal.Trabajo_U.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private int status; // Código HTTP (ej. 400, 404, 500)
    private String mensaje; // Descripción general del error
    private Object detalles; // Puede ser un String, List<String>, Map, etc.
    private LocalDateTime timestamp; // Fecha y hora del error
}
