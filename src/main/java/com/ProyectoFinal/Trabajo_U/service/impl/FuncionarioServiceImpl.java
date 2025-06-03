package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.FuncionarioDTO;
import com.ProyectoFinal.Trabajo_U.model.Funcionario;
import com.ProyectoFinal.Trabajo_U.repository.FuncionarioRepository;
import com.ProyectoFinal.Trabajo_U.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public FuncionarioDTO crear(FuncionarioDTO dto) {
        Funcionario funcionario = dtoToEntity(dto);
        Funcionario guardado = funcionarioRepository.save(funcionario);
        return entityToDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public FuncionarioDTO obtenerPorId(Long id) {
        return funcionarioRepository.findById(id)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public List<FuncionarioDTO> listar() {
        return funcionarioRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FuncionarioDTO actualizar(Long id, FuncionarioDTO dto) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNombres(dto.getNombres());
            funcionario.setApellidoPaterno(dto.getApellidoPaterno());
            funcionario.setApellidoMaterno(dto.getApellidoMaterno());
            funcionario.setCorreo(dto.getCorreo());
            funcionario.setCiudad(dto.getCiudad());
            funcionario.setTelefono(dto.getTelefono());
            funcionario.setSexo(dto.getSexo());
            funcionario.setCi(dto.getCi());
            funcionario.setFechaNacimiento(dto.getFechaNacimiento());
            funcionario.setCargo(dto.getCargo());
            funcionario.setUnidad(dto.getUnidad());
            return entityToDto(funcionarioRepository.save(funcionario));
        }).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    // Métodos de mapeo
    private Funcionario dtoToEntity(FuncionarioDTO dto) {
        return Funcionario.builder()
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
                .cargo(dto.getCargo())
                .unidad(dto.getUnidad())
                .build();
    }

    private FuncionarioDTO entityToDto(Funcionario funcionario) {
        return FuncionarioDTO.builder()
                .id(funcionario.getId())
                .nombres(funcionario.getNombres())
                .apellidoPaterno(funcionario.getApellidoPaterno())
                .apellidoMaterno(funcionario.getApellidoMaterno())
                .ci(funcionario.getCi())
                .sexo(funcionario.getSexo())
                .fechaNacimiento(funcionario.getFechaNacimiento())
                .correo(funcionario.getCorreo())
                .ciudad(funcionario.getCiudad())
                .telefono(funcionario.getTelefono())
                .cargo(funcionario.getCargo())
                .unidad(funcionario.getUnidad())
                .build();
    }
}
