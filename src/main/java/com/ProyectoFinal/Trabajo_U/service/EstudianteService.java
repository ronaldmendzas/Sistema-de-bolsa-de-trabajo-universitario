package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.dto.EstudianteDTO;
import com.lowagie.text.DocumentException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface EstudianteService {
    EstudianteDTO crear(EstudianteDTO estudianteDTO);

    EstudianteDTO obtenerPorId(Long id);

    List<EstudianteDTO> listar();

    EstudianteDTO actualizar(Long id, EstudianteDTO estudianteDTO);

    void eliminar(Long id);

    byte[] generarReportePdf() throws DocumentException;

}
