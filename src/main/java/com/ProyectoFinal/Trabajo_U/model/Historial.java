package com.ProyectoFinal.Trabajo_U.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "historial")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "convocatoria_id", nullable = false)
    private Convocatorias convocatoria;

    @Column(name = "estado_final", nullable = false, length = 50)
    private String estadoFinal; // Ej: "Aceptado", "Rechazado", "Desistido"

    @Column(name = "fecha_resolucion", nullable = false)
    private LocalDate fechaResolucion;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Version
    private Integer version;
}
