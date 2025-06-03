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
@Table(name = "documento")
public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Long id;

    @Column(name = "nombre_archivo", nullable = false, length = 255)
    private String nombreArchivo;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo; // Ej: "CV", "Carta", "Certificado", etc.

    @Column(name = "descripcion")
    private String descripcion;

    @Lob
    @Column(name = "contenido", nullable = false)
    private byte[] contenido;

    @Column(name = "fecha_subida", nullable = false)
    private LocalDate fechaSubida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @Version
    private Integer version;

}