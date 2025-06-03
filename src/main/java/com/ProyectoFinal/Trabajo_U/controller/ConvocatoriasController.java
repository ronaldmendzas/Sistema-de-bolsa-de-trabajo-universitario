package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.ConvocatoriasDTO;
import com.ProyectoFinal.Trabajo_U.service.ConvocatoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
