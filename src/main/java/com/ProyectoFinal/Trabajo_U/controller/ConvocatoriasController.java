package com.ProyectoFinal.Trabajo_U.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinal.Trabajo_U.dto.ConvocatoriasDTO;
import com.ProyectoFinal.Trabajo_U.service.ConvocatoriasService;

@RestController
@RequestMapping("/api/BolsaU/convocatorias")
@CrossOrigin(origins = "*")
public class ConvocatoriasController {

    @Autowired
    private ConvocatoriasService convocatoriaService;

    // ✅ Listar convocatorias paginadas
    @GetMapping("/paginado")
    public ResponseEntity<Page<ConvocatoriasDTO>> listarPaginado(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(convocatoriaService.listarPaginado(pageable));
    }

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
}
