package com.ProyectoFinal.Trabajo_U.validation;

import com.ProyectoFinal.Trabajo_U.dto.PersonaDTO;
import com.ProyectoFinal.Trabajo_U.repository.PersonaRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonaValidator {
    //
    private final PersonaRepository personaRepository;

    //
    public PersonaValidator(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    //
    public void validarEmailUnico(String email) {
        if (personaRepository.findAll().stream().anyMatch(p -> p.getCorreo().equalsIgnoreCase(email))) {
            throw new IllegalArgumentException("Ya existe una persona con este correo electrónico");
        }
    }

    //
    public void validarDominioEmail(String email) {
        String dominio = email.substring(email.indexOf('@') + 1);
        List<String> dominiosBloqueados = Arrays.asList("dominiobloqueado.com",
                "correo-no-valido.com");
        if (dominiosBloqueados.contains(dominio)) {
            throw new IllegalArgumentException("El dominio de email no está permitido");
        }
    }

    public void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío o nulo.");
        }
    }

    public void validarApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido es obligatorio y no puede estar vacío.");
        }
    }

    public void validacionCompletaPersona(PersonaDTO persona) {
        validarEmailUnico(persona.getCorreo());
        validarDominioEmail(persona.getCorreo());
        validarNombre(persona.getNombres());
        validarApellido(persona.getApellidoPaterno());
        // Puedes agregar más validaciones según tu necesidad
    }
}
