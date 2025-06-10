package com.ProyectoFinal.Trabajo_U.repository;

import com.ProyectoFinal.Trabajo_U.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // Buscar estudiantes por carrera
    List<Estudiante> findByCarrera(String carrera);

    // Buscar estudiantes por matrícula
    Estudiante findByMatricula(String matricula);

    // Buscar estudiantes por nivel
    List<Estudiante> findByNivel(int nivel);

    // Verificar si ya existe un estudiante con una matrícula específica
    boolean existsByMatricula(String matricula);
}
