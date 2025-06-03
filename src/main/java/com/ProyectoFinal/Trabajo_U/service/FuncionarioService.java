package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.dto.FuncionarioDTO;
import java.util.List;

public interface FuncionarioService {
    FuncionarioDTO crear(FuncionarioDTO funcionarioDTO);

    FuncionarioDTO obtenerPorId(Long id);

    List<FuncionarioDTO> listar();

    FuncionarioDTO actualizar(Long id, FuncionarioDTO funcionarioDTO);

    void eliminar(Long id);
}
