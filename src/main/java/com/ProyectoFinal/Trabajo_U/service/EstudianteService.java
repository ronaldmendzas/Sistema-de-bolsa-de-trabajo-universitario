package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.dto.EstudianteDTO;

import java.util.List;

public interface EstudianteService {
    EstudianteDTO crear(EstudianteDTO estudianteDTO);

    EstudianteDTO obtenerPorId(Long id);

    List<EstudianteDTO> listar();

    EstudianteDTO actualizar(Long id, EstudianteDTO estudianteDTO);

    void eliminar(Long id);
}
