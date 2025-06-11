package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.dto.HistorialDTO;

import java.util.List;

public interface HistorialService {

    HistorialDTO crear(HistorialDTO historialDTO);

    HistorialDTO obtenerPorId(Long id);

    List<HistorialDTO> listar();

    HistorialDTO actualizar(Long id, HistorialDTO historialDTO);

    void eliminar(Long id);
}
