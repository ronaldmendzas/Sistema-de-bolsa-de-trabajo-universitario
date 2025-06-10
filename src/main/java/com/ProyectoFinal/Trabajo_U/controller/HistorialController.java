package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.HistorialDTO;
import com.ProyectoFinal.Trabajo_U.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/BolsaU/historiales")
@CrossOrigin(origins = "*")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    // Crear historial
    @PostMapping
    public HistorialDTO crear(@RequestBody HistorialDTO dto) {
        return historialService.crear(dto);
    }

    // Obtener historial por ID
    @GetMapping("/{id}")
    public HistorialDTO obtenerPorId(@PathVariable Long id) {
        return historialService.obtenerPorId(id);
    }

    // Listar todos los historiales
    @GetMapping
    public List<HistorialDTO> listar() {
        return historialService.listar();
    }

    // Actualizar historial
    @PutMapping("/{id}")
    public HistorialDTO actualizar(@PathVariable Long id, @RequestBody HistorialDTO dto) {
        return historialService.actualizar(id, dto);
    }

    // Eliminar historial
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        historialService.eliminar(id);
    }
}
