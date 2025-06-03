package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.FuncionarioDTO;
import com.ProyectoFinal.Trabajo_U.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/BolsaU/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Crear funcionario
    @PostMapping
    public FuncionarioDTO crear(@RequestBody FuncionarioDTO dto) {
        return funcionarioService.crear(dto);
    }

    // Obtener funcionario por ID
    @GetMapping("/{id}")
    public FuncionarioDTO obtenerPorId(@PathVariable Long id) {
        return funcionarioService.obtenerPorId(id);
    }

    // Listar todos los funcionarios
    @GetMapping
    public List<FuncionarioDTO> listar() {
        return funcionarioService.listar();
    }

    // Actualizar funcionario
    @PutMapping("/{id}")
    public FuncionarioDTO actualizar(@PathVariable Long id, @RequestBody FuncionarioDTO dto) {
        return funcionarioService.actualizar(id, dto);
    }

    // Eliminar funcionario
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        funcionarioService.eliminar(id);
    }
}
