package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.DocumentosDTO;
import com.ProyectoFinal.Trabajo_U.service.DocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/BolsaU/documentos")
@CrossOrigin(origins = "*")
public class DocumentosController {

    @Autowired
    private DocumentosService documentoService;

    // Crear documento
    @PostMapping
    public DocumentosDTO crear(@RequestBody DocumentosDTO dto) {
        return documentoService.crear(dto);
    }

    // Obtener documento por ID
    @GetMapping("/{id}")
    public DocumentosDTO obtenerPorId(@PathVariable Long id) {
        return documentoService.obtenerPorId(id);
    }

    // Listar todos los documentos
    @GetMapping
    public List<DocumentosDTO> listar() {
        return documentoService.listar();
    }

    // Actualizar documento
    @PutMapping("/{id}")
    public DocumentosDTO actualizar(@PathVariable Long id, @RequestBody DocumentosDTO dto) {
        return documentoService.actualizar(id, dto);
    }

    // Eliminar documento
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        documentoService.eliminar(id);
    }
}
