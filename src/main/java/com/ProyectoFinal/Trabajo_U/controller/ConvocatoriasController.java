package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.ConvocatoriasDTO;
import com.ProyectoFinal.Trabajo_U.service.ConvocatoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lowagie.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/BolsaU/convocatorias")
@CrossOrigin(origins = "*")
public class ConvocatoriasController {

    @Autowired
    private ConvocatoriasService convocatoriaService;

    // Crear convocatoria
    @PostMapping
    public ConvocatoriasDTO crear(@RequestBody ConvocatoriasDTO dto) {
        return convocatoriaService.crear(dto);
    }

    // Obtener convocatoria por ID
    @GetMapping("/{id}")
    public ConvocatoriasDTO obtenerPorId(@PathVariable Long id) {
        return convocatoriaService.obtenerPorId(id);
    }

    // Listar todas las convocatorias
    @GetMapping
    public List<ConvocatoriasDTO> listar() {
        return convocatoriaService.listar();
    }

    // Actualizar convocatoria
    @PutMapping("/{id}")
    public ConvocatoriasDTO actualizar(@PathVariable Long id, @RequestBody ConvocatoriasDTO dto) {
        return convocatoriaService.actualizar(id, dto);
    }

    // Eliminar convocatoria
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        convocatoriaService.eliminar(id);
    }

    @GetMapping(value = "/reporte/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> descargarReportePdf() {
        try {
            byte[] pdfBytes = convocatoriaService.generarReportePdf();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=convocatorias_reporte.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);

        } catch (DocumentException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
