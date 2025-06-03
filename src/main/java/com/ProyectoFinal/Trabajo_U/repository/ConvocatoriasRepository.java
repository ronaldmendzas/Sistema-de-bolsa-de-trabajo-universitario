package com.ProyectoFinal.Trabajo_U.repository;

import com.ProyectoFinal.Trabajo_U.model.Convocatorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConvocatoriasRepository extends JpaRepository<Convocatorias, Long> {

    // Buscar convocatorias por título (contiene texto, ignorando mayúsculas)
    List<Convocatorias> findByTituloContainingIgnoreCase(String titulo);

    // Buscar convocatorias entre dos fechas
    List<Convocatorias> findByFechaPublicacionBetween(LocalDate inicio, LocalDate fin);

    // Buscar convocatorias aún abiertas
    List<Convocatorias> findByFechaCierreAfter(LocalDate fechaActual);

    // Buscar convocatorias que ya cerraron
    List<Convocatorias> findByFechaCierreBefore(LocalDate fechaActual);
}
