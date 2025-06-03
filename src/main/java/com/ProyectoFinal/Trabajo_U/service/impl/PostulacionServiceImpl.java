package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.PostulacionDTO;
import com.ProyectoFinal.Trabajo_U.model.Convocatorias;
import com.ProyectoFinal.Trabajo_U.model.Persona;
import com.ProyectoFinal.Trabajo_U.model.Postulacion;
import com.ProyectoFinal.Trabajo_U.repository.ConvocatoriasRepository;
import com.ProyectoFinal.Trabajo_U.repository.PersonaRepository;
import com.ProyectoFinal.Trabajo_U.repository.PostulacionRepository;
import com.ProyectoFinal.Trabajo_U.service.PostulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostulacionServiceImpl implements PostulacionService {

    @Autowired
    private PostulacionRepository postulacionRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ConvocatoriasRepository convocatoriaRepository;

    @Override
    @Transactional
    public PostulacionDTO crear(PostulacionDTO dto) {
        Optional<Persona> personaOpt = personaRepository.findById(dto.getPersonaId());
        Optional<Convocatorias> convocatoriaOpt = convocatoriaRepository.findById(dto.getConvocatoriaId());

        if (personaOpt.isEmpty() || convocatoriaOpt.isEmpty()) {
            return null;
        }

        Postulacion postulacion = Postulacion.builder()
                .fechaPostulacion(dto.getFechaPostulacion())
                .estado(dto.getEstado())
                .persona(personaOpt.get())
                .convocatoria(convocatoriaOpt.get())
                .build();

        return entityToDto(postulacionRepository.save(postulacion));
    }

    @Override
    @Transactional(readOnly = true)
    public PostulacionDTO obtenerPorId(Long id) {
        return postulacionRepository.findById(id)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public List<PostulacionDTO> listar() {
        return postulacionRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PostulacionDTO actualizar(Long id, PostulacionDTO dto) {
        return postulacionRepository.findById(id).map(postulacion -> {
            postulacion.setFechaPostulacion(dto.getFechaPostulacion());
            postulacion.setEstado(dto.getEstado());
            return entityToDto(postulacionRepository.save(postulacion));
        }).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        postulacionRepository.deleteById(id);
    }

    private PostulacionDTO entityToDto(Postulacion p) {
        return PostulacionDTO.builder()
                .id(p.getId())
                .fechaPostulacion(p.getFechaPostulacion())
                .estado(p.getEstado())
                .personaId(p.getPersona().getId())
                .convocatoriaId(p.getConvocatoria().getId())
                .build();
    }
}
