package com.ProyectoFinal.Trabajo_U.repository;

import com.ProyectoFinal.Trabajo_U.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    // Buscar docentes por grado académico exacto
    List<Docente> findByGradoAcademico(String gradoAcademico);

    // Buscar docentes por área de especialidad exacta
    List<Docente> findByAreaEspecialidad(String areaEspecialidad);

    // Buscar por nombre o apellido (heredados de Persona)
    List<Docente> findByNombresContainingIgnoreCase(String nombres);

    List<Docente> findByApellidoPaternoContainingIgnoreCase(String apellido);

    // Verificar si ya existe un docente con un CI específico
    boolean existsByCi(String ci);
}
