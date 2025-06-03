package com.ProyectoFinal.Trabajo_U.repository;

import com.ProyectoFinal.Trabajo_U.model.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DocumentosRepository extends JpaRepository<Documentos, Long> {

    // Buscar documentos por persona
    List<Documentos> findByPersonaId(Long personaId);

    // Buscar documentos por tipo (CV, Carta, Certificado, etc.)
    List<Documentos> findByTipo(String tipo);

    // Buscar documentos por nombre (contiene texto, ignorando mayúsculas)
    List<Documentos> findByNombreArchivoContainingIgnoreCase(String nombreArchivo);

    // Buscar documentos subidos en una fecha específica
    List<Documentos> findByFechaSubida(LocalDate fecha);

    // Verificar si ya se subió un documento de cierto tipo para una persona
    boolean existsByPersonaIdAndTipo(Long personaId, String tipo);
}
