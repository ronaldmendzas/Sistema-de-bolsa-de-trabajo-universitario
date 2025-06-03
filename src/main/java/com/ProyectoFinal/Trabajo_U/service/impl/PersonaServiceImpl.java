package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.model.Persona;
import com.ProyectoFinal.Trabajo_U.service.PersonaService;
import com.ProyectoFinal.Trabajo_U.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> obtenerPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional
    public Persona actualizar(Long id, Persona personaActualizada) {
        return personaRepository.findById(id).map(persona -> {
            persona.setNombres(personaActualizada.getNombres());
            persona.setApellidoPaterno(personaActualizada.getApellidoPaterno());
            persona.setApellidoMaterno(personaActualizada.getApellidoMaterno());
            persona.setCorreo(personaActualizada.getCorreo());
            persona.setCiudad(personaActualizada.getCiudad());
            persona.setTelefono(personaActualizada.getTelefono());
            persona.setSexo(personaActualizada.getSexo());
            persona.setCi(personaActualizada.getCi());
            persona.setFechaNacimiento(personaActualizada.getFechaNacimiento());
            return personaRepository.save(persona);
        }).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> buscarPorCi(String ci) {
        return personaRepository.findByCi(ci);
    }

    @Override
    public List<Persona> buscarPorApellido(String apellido) {
        return personaRepository.findByApellidoPaternoContainingIgnoreCase(apellido);
    }
}
