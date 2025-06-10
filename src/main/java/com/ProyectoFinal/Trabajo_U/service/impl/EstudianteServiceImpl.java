package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.EstudianteDTO;
import com.ProyectoFinal.Trabajo_U.model.Estudiante;
import com.ProyectoFinal.Trabajo_U.repository.EstudianteRepository;
import com.ProyectoFinal.Trabajo_U.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    @Transactional
    public EstudianteDTO crear(EstudianteDTO dto) {
        Estudiante estudiante = dtoToEntity(dto);
        Estudiante guardado = estudianteRepository.save(estudiante);
        return entityToDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public EstudianteDTO obtenerPorId(Long id) {
        return estudianteRepository.findById(id)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public List<EstudianteDTO> listar() {
        return estudianteRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EstudianteDTO actualizar(Long id, EstudianteDTO dto) {
        return estudianteRepository.findById(id).map(estudiante -> {
            estudiante.setNombres(dto.getNombres());
            estudiante.setApellidoPaterno(dto.getApellidoPaterno());
            estudiante.setApellidoMaterno(dto.getApellidoMaterno());
            estudiante.setCorreo(dto.getCorreo());
            estudiante.setCiudad(dto.getCiudad());
            estudiante.setTelefono(dto.getTelefono());
            estudiante.setSexo(dto.getSexo());
            estudiante.setCi(dto.getCi());
            estudiante.setFechaNacimiento(dto.getFechaNacimiento());
            estudiante.setCarrera(dto.getCarrera());
            estudiante.setMatricula(dto.getMatricula());
            estudiante.setNivel(dto.getNivel());
            return entityToDto(estudianteRepository.save(estudiante));
        }).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }

    // Métodos de mapeo
    private Estudiante dtoToEntity(EstudianteDTO dto) {
        return Estudiante.builder()
                .id(dto.getId())
                .nombres(dto.getNombres())
                .apellidoPaterno(dto.getApellidoPaterno())
                .apellidoMaterno(dto.getApellidoMaterno())
                .ci(dto.getCi())
                .sexo(dto.getSexo())
                .fechaNacimiento(dto.getFechaNacimiento())
                .correo(dto.getCorreo())
                .ciudad(dto.getCiudad())
                .telefono(dto.getTelefono())
                .carrera(dto.getCarrera())
                .matricula(dto.getMatricula())
                .nivel(dto.getNivel())
                .build();
    }

    private EstudianteDTO entityToDto(Estudiante estudiante) {
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombres(estudiante.getNombres())
                .apellidoPaterno(estudiante.getApellidoPaterno())
                .apellidoMaterno(estudiante.getApellidoMaterno())
                .ci(estudiante.getCi())
                .sexo(estudiante.getSexo())
                .fechaNacimiento(estudiante.getFechaNacimiento())
                .correo(estudiante.getCorreo())
                .ciudad(estudiante.getCiudad())
                .telefono(estudiante.getTelefono())
                .carrera(estudiante.getCarrera())
                .matricula(estudiante.getMatricula())
                .nivel(estudiante.getNivel())
                .build();
    }
}
