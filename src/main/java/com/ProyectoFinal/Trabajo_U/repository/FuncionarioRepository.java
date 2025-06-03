package com.ProyectoFinal.Trabajo_U.repository;

import com.ProyectoFinal.Trabajo_U.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Buscar por cargo exacto
    List<Funcionario> findByCargo(String cargo);

    // Buscar por unidad exacta
    List<Funcionario> findByUnidad(String unidad);

    // Buscar por parte del nombre o apellido (heredado de Persona)
    List<Funcionario> findByNombresContainingIgnoreCase(String nombres);

    List<Funcionario> findByApellidoPaternoContainingIgnoreCase(String apellido);

    // Verificar si existe un funcionario por CI (heredado de Persona)
    boolean existsByCi(String ci);
}
