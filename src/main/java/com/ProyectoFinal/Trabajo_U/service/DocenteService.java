package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.dto.DocenteDTO;
import java.util.List;

public interface DocenteService {
    DocenteDTO crear(DocenteDTO docenteDTO);

    DocenteDTO obtenerPorId(Long id);

    List<DocenteDTO> listar();

    DocenteDTO actualizar(Long id, DocenteDTO docenteDTO);

    void eliminar(Long id);
}
