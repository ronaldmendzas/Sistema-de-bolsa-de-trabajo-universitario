package com.ProyectoFinal.Trabajo_U.controller;

import com.ProyectoFinal.Trabajo_U.dto.PersonaDTO;
import com.ProyectoFinal.Trabajo_U.model.Persona;
import com.ProyectoFinal.Trabajo_U.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/BolsaU/personas")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public PersonaDTO crear(@RequestBody PersonaDTO dto) {
        Persona persona = dtoToEntity(dto);
        return entityToDto(personaService.crear(persona));
    }

    @GetMapping("/{id}")
    public PersonaDTO obtenerPorId(@PathVariable Long id) {
        Optional<Persona> persona = personaService.obtenerPorId(id);
        return persona.map(this::entityToDto).orElse(null);
    }

    @GetMapping
    public List<PersonaDTO> listar() {
        return personaService.listar()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PersonaDTO actualizar(@PathVariable Long id, @RequestBody PersonaDTO dto) {
        Persona personaActualizada = dtoToEntity(dto);
        return entityToDto(personaService.actualizar(id, personaActualizada));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        personaService.eliminar(id);
    }

    private Persona dtoToEntity(PersonaDTO dto) {
        Persona persona = new Persona() {
            {
                setId(dto.getId());
                setNombres(dto.getNombres());
                setApellidoPaterno(dto.getApellidoPaterno());
                setApellidoMaterno(dto.getApellidoMaterno());
                setCi(dto.getCi());
                setSexo(dto.getSexo());
                setFechaNacimiento(dto.getFechaNacimiento());
                setCorreo(dto.getCorreo());
                setCiudad(dto.getCiudad());
                setTelefono(dto.getTelefono());
            }
        };
        return persona;
    }

    private PersonaDTO entityToDto(Persona p) {
        return PersonaDTO.builder()
                .id(p.getId())
                .nombres(p.getNombres())
                .apellidoPaterno(p.getApellidoPaterno())
                .apellidoMaterno(p.getApellidoMaterno())
                .ci(p.getCi())
                .sexo(p.getSexo())
                .fechaNacimiento(p.getFechaNacimiento())
                .correo(p.getCorreo())
                .ciudad(p.getCiudad())
                .telefono(p.getTelefono())
                .build();
    }
}
