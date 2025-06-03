package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    Persona crear(Persona persona);

    Optional<Persona> obtenerPorId(Long id);

    List<Persona> listar();

    Persona actualizar(Long id, Persona persona);

    void eliminar(Long id);

    Optional<Persona> buscarPorCi(String ci);

    List<Persona> buscarPorApellido(String apellido);
}
