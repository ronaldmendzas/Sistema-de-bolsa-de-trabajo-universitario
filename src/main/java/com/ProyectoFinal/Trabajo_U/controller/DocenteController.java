package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.DocenteDTO;
import com.ProyectoFinal.Trabajo_U.model.Docente;
import com.ProyectoFinal.Trabajo_U.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/BolsaU/docentes")
@CrossOrigin(origins = "*")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    // Crear docente
    @PostMapping
    public DocenteDTO crear(@RequestBody DocenteDTO dto) {
        return docenteService.crear(dto);
    }

    // Obtener docente por ID
    @GetMapping("/{id}")
    public DocenteDTO obtenerPorId(@PathVariable Long id) {
        return docenteService.obtenerPorId(id);
    }

    // Listar todos los docentes
    @GetMapping
    public List<DocenteDTO> listar() {
        return docenteService.listar();
    }

    // Actualizar docente
    @PutMapping("/{id}")
    public DocenteDTO actualizar(@PathVariable Long id, @RequestBody DocenteDTO dto) {
        return docenteService.actualizar(id, dto);
    }

    // Eliminar docente
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        docenteService.eliminar(id);
    }
}
