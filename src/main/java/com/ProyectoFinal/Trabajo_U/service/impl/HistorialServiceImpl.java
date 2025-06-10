package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.HistorialDTO;
import com.ProyectoFinal.Trabajo_U.model.Historial;
import com.ProyectoFinal.Trabajo_U.repository.ConvocatoriasRepository;
import com.ProyectoFinal.Trabajo_U.repository.HistorialRepository;
import com.ProyectoFinal.Trabajo_U.repository.PersonaRepository;
import com.ProyectoFinal.Trabajo_U.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private ConvocatoriasRepository convocatoriasRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public HistorialDTO crear(HistorialDTO dto) {
        Historial historial = dtoToEntity(dto);
        Historial guardado = historialRepository.save(historial);
        return entityToDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public HistorialDTO obtenerPorId(Long id) {
        return historialRepository.findById(id)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public List<HistorialDTO> listar() {
        return historialRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HistorialDTO actualizar(Long id, HistorialDTO dto) {
        return historialRepository.findById(id).map(historial -> {
            historial.setPersona(personaRepository.findById(dto.getPersonaId()).orElse(null));
            historial.setConvocatoria(convocatoriasRepository.findById(dto.getConvocatoriaId()).orElse(null));
            historial.setEstadoFinal(dto.getEstadoFinal());
            historial.setFechaResolucion(dto.getFechaResolucion());
            historial.setObservaciones(dto.getObservaciones());
            return entityToDto(historialRepository.save(historial));
        }).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        historialRepository.deleteById(id);
    }

    // Métodos de mapeo
    private Historial dtoToEntity(HistorialDTO dto) {
        return Historial.builder()
                .id(dto.getId())
                .persona(personaRepository.findById(dto.getPersonaId()).orElse(null))
                .convocatoria(convocatoriasRepository.findById(dto.getConvocatoriaId()).orElse(null))
                .estadoFinal(dto.getEstadoFinal())
                .fechaResolucion(dto.getFechaResolucion())
                .observaciones(dto.getObservaciones())
                .version(dto.getVersion())
                .build();
    }

    private HistorialDTO entityToDto(Historial historial) {
        return HistorialDTO.builder()
                .id(historial.getId())
                .personaId(historial.getPersona().getId()) // Asignación en el service según lógica de negocio
                .convocatoriaId(historial.getConvocatoria().getId()) // Asignación en el service según lógica de negocio
                .estadoFinal(historial.getEstadoFinal())
                .fechaResolucion(historial.getFechaResolucion())
                .observaciones(historial.getObservaciones())
                .version(historial.getVersion())
                .build();
    }
}
