package com.ProyectoFinal.Trabajo_U.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ProyectoFinal.Trabajo_U.dto.ConvocatoriasDTO;

public interface ConvocatoriasService {
    ConvocatoriasDTO crear(ConvocatoriasDTO dto);

    ConvocatoriasDTO obtenerPorId(Long id);

    List<ConvocatoriasDTO> listar();

    ConvocatoriasDTO actualizar(Long id, ConvocatoriasDTO dto);

    void eliminar(Long id);

    Page<ConvocatoriasDTO> listarPaginado(Pageable pageable);
}
