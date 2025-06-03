package com.ProyectoFinal.Trabajo_U.registro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de prueba para validar accesos según roles definidos.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/BolsaU/usuarios")
public class UsuarioController {

    // Ruta pública sin autenticación
    @GetMapping("/public/test")
    @PreAuthorize("permitAll()")
    public String allAccess() {
        return "Contenido público accesible sin autenticación.";
    }

    // Ruta protegida accesible por FUNCIONARIO, DOCENTE o ADMIN
    @GetMapping("/funcionarios/test")
    @PreAuthorize("hasRole('FUNCIONARIO') or hasRole('DOCENTE') or hasRole('ADMIN')")
    public String funcionarioAccess() {
        return "📄 Contenido para funcionarios (o docentes o admins).";
    }

    // Ruta protegida accesible por DOCENTE o ADMIN
    @GetMapping("/docentes/test")
    @PreAuthorize("hasRole('DOCENTE') or hasRole('ADMIN')")
    public String docenteAccess() {
        return "📘 Contenido para docentes (o admins).";
    }

    // Ruta protegida accesible solo por ADMIN
    @GetMapping("/admin/test")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "🔐 Contenido exclusivo para administradores.";
    }
}
