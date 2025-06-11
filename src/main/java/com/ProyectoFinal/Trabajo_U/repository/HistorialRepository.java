package com.ProyectoFinal.Trabajo_U.repository;

import com.ProyectoFinal.Trabajo_U.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {
}
