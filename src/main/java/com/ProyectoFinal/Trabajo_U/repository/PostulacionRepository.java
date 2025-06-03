package com.ProyectoFinal.Trabajo_U.repository;

import com.ProyectoFinal.Trabajo_U.model.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {

    // Buscar postulaciones por persona
    List<Postulacion> findByPersonaId(Long personaId);

    // Buscar postulaciones por convocatoria
    List<Postulacion> findByConvocatoriaId(Long convocatoriaId);

    // Verificar si una persona ya se postuló a una convocatoria
    boolean existsByPersonaIdAndConvocatoriaId(Long personaId, Long convocatoriaId);

    // Obtener una postulación específica
    Optional<Postulacion> findByPersonaIdAndConvocatoriaId(Long personaId, Long convocatoriaId);
}
