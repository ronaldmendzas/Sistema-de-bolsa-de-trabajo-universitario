package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.DocenteDTO;
import com.ProyectoFinal.Trabajo_U.model.Docente;
import com.ProyectoFinal.Trabajo_U.repository.DocenteRepository;
import com.ProyectoFinal.Trabajo_U.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    @Transactional
    public DocenteDTO crear(DocenteDTO dto) {
        Docente docente = dtoToEntity(dto);
        Docente guardado = docenteRepository.save(docente);
        return entityToDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public DocenteDTO obtenerPorId(Long id) {
        return docenteRepository.findById(id)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public List<DocenteDTO> listar() {
        return docenteRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DocenteDTO actualizar(Long id, DocenteDTO dto) {
        return docenteRepository.findById(id).map(docente -> {
            docente.setNombres(dto.getNombres());
            docente.setApellidoPaterno(dto.getApellidoPaterno());
            docente.setApellidoMaterno(dto.getApellidoMaterno());
            docente.setCorreo(dto.getCorreo());
            docente.setCiudad(dto.getCiudad());
            docente.setTelefono(dto.getTelefono());
            docente.setSexo(dto.getSexo());
            docente.setCi(dto.getCi());
            docente.setFechaNacimiento(dto.getFechaNacimiento());
            docente.setGradoAcademico(dto.getGradoAcademico());
            docente.setAreaEspecialidad(dto.getAreaEspecialidad());
            return entityToDto(docenteRepository.save(docente));
        }).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        docenteRepository.deleteById(id);
    }

    // Métodos de mapeo
    private Docente dtoToEntity(DocenteDTO dto) {
        return Docente.builder()
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
                .gradoAcademico(dto.getGradoAcademico())
                .areaEspecialidad(dto.getAreaEspecialidad())
                .build();
    }

    private DocenteDTO entityToDto(Docente docente) {
        return DocenteDTO.builder()
                .id(docente.getId())
                .nombres(docente.getNombres())
                .apellidoPaterno(docente.getApellidoPaterno())
                .apellidoMaterno(docente.getApellidoMaterno())
                .ci(docente.getCi())
                .sexo(docente.getSexo())
                .fechaNacimiento(docente.getFechaNacimiento())
                .correo(docente.getCorreo())
                .ciudad(docente.getCiudad())
                .telefono(docente.getTelefono())
                .gradoAcademico(docente.getGradoAcademico())
                .areaEspecialidad(docente.getAreaEspecialidad())
                .build();
    }
}
