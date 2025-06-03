package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.dto.ConvocatoriasDTO;
import java.util.List;

public interface ConvocatoriasService {
    ConvocatoriasDTO crear(ConvocatoriasDTO dto);

    ConvocatoriasDTO obtenerPorId(Long id);

    List<ConvocatoriasDTO> listar();

    ConvocatoriasDTO actualizar(Long id, ConvocatoriasDTO dto);

    void eliminar(Long id);
}
