package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.EstudianteDTO;
import com.ProyectoFinal.Trabajo_U.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lowagie.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

@RestController
@RequestMapping("/api/BolsaU/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Crear estudiante
    @PostMapping
    public EstudianteDTO crear(@RequestBody EstudianteDTO dto) {
        return estudianteService.crear(dto);
    }

    // Obtener estudiante por ID
    @GetMapping("/{id}")
    public EstudianteDTO obtenerPorId(@PathVariable Long id) {
        return estudianteService.obtenerPorId(id);
    }

    // Listar todos los estudiantes
    @GetMapping
    public List<EstudianteDTO> listar() {
        return estudianteService.listar();
    }

    // Actualizar estudiante
    @PutMapping("/{id}")
    public EstudianteDTO actualizar(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        return estudianteService.actualizar(id, dto);
    }

    // Eliminar estudiante
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
    }

    @GetMapping(value = "/reporte/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> descargarReportePdf() {
        try {
            byte[] pdfBytes = estudianteService.generarReportePdf();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=estudiantes_reporte.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);

        } catch (DocumentException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
