package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.ConvocatoriasDTO;
import com.ProyectoFinal.Trabajo_U.model.Convocatorias;
import com.ProyectoFinal.Trabajo_U.repository.ConvocatoriasRepository;
import com.ProyectoFinal.Trabajo_U.service.ConvocatoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConvocatoriasServiceImpl implements ConvocatoriasService {

    @Autowired
    private ConvocatoriasRepository convocatoriaRepository;

    @Transactional
    @Override
    public ConvocatoriasDTO crear(ConvocatoriasDTO dto) {
        Convocatorias convocatoria = dtoToEntity(dto);
        return entityToDto(convocatoriaRepository.save(convocatoria));
    }

    @Override
    @Transactional(readOnly = true) // solo lectura
    public ConvocatoriasDTO obtenerPorId(Long id) {
        return convocatoriaRepository.findById(id)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public List<ConvocatoriasDTO> listar() {
        return convocatoriaRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ConvocatoriasDTO actualizar(Long id, ConvocatoriasDTO dto) {
        return convocatoriaRepository.findById(id).map(convocatoria -> {
            convocatoria.setTitulo(dto.getTitulo());
            convocatoria.setDescripcion(dto.getDescripcion());
            convocatoria.setFechaPublicacion(dto.getFechaPublicacion());
            convocatoria.setFechaCierre(dto.getFechaCierre());
            return entityToDto(convocatoriaRepository.save(convocatoria));
        }).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        convocatoriaRepository.deleteById(id);
    }

    // Métodos de mapeo
    private Convocatorias dtoToEntity(ConvocatoriasDTO dto) {
        return Convocatorias.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .fechaPublicacion(dto.getFechaPublicacion())
                .fechaCierre(dto.getFechaCierre())
                .build();
    }

    private ConvocatoriasDTO entityToDto(Convocatorias c) {
        return ConvocatoriasDTO.builder()
                .id(c.getId())
                .titulo(c.getTitulo())
                .descripcion(c.getDescripcion())
                .fechaPublicacion(c.getFechaPublicacion())
                .fechaCierre(c.getFechaCierre())
                .build();
    }
}
