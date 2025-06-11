package com.ProyectoFinal.Trabajo_U.service;

import com.ProyectoFinal.Trabajo_U.dto.PostulacionDTO;
import java.util.List;

public interface PostulacionService {
    PostulacionDTO crear(PostulacionDTO dto);

    PostulacionDTO obtenerPorId(Long id);

    List<PostulacionDTO> listar();

    PostulacionDTO actualizar(Long id, PostulacionDTO dto);

    void eliminar(Long id);

    byte[] generarReportePdf() throws com.lowagie.text.DocumentException;

}
