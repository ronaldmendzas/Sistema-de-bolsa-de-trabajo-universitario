package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.dto.DocumentosDTO;
import java.util.List;

public interface DocumentosService {
    DocumentosDTO crear(DocumentosDTO dto);

    DocumentosDTO obtenerPorId(Long id);

    List<DocumentosDTO> listar();

    DocumentosDTO actualizar(Long id, DocumentosDTO dto);

    void eliminar(Long id);
}
