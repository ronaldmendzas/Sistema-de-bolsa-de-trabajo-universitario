package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.PostulacionDTO;
import com.ProyectoFinal.Trabajo_U.service.PostulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/BolsaU/postulaciones")
@CrossOrigin(origins = "*")
public class PostulacionController {

    @Autowired
    private PostulacionService postulacionService;

    // Crear postulación
    @PostMapping
    public PostulacionDTO crear(@RequestBody PostulacionDTO dto) {
        return postulacionService.crear(dto);
    }

    // Obtener postulación por ID
    @GetMapping("/{id}")
    public PostulacionDTO obtenerPorId(@PathVariable Long id) {
        return postulacionService.obtenerPorId(id);
    }

    // Listar todas las postulaciones
    @GetMapping
    public List<PostulacionDTO> listar() {
        return postulacionService.listar();
    }

    // Actualizar postulación
    @PutMapping("/{id}")
    public PostulacionDTO actualizar(@PathVariable Long id, @RequestBody PostulacionDTO dto) {
        return postulacionService.actualizar(id, dto);
    }

    // Eliminar postulación
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        postulacionService.eliminar(id);
    }
}
