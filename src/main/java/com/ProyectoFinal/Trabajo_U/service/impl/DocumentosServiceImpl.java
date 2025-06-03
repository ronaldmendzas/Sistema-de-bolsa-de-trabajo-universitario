package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.DocumentosDTO;
import com.ProyectoFinal.Trabajo_U.model.Documentos;
import com.ProyectoFinal.Trabajo_U.model.Persona;
import com.ProyectoFinal.Trabajo_U.repository.DocumentosRepository;
import com.ProyectoFinal.Trabajo_U.repository.PersonaRepository;
import com.ProyectoFinal.Trabajo_U.service.DocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentosServiceImpl implements DocumentosService {

    @Autowired
    private DocumentosRepository documentosRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public DocumentosDTO crear(DocumentosDTO dto) {
        Optional<Persona> personaOpt = personaRepository.findById(dto.getPersonaId());

        if (personaOpt.isEmpty()) {
            return null;
        }

        Documentos documento = Documentos.builder()
                .nombreArchivo(dto.getNombreArchivo())
                .tipo(dto.getTipo())
                .descripcion(dto.getDescripcion())
                .contenido(dto.getContenido())
                .fechaSubida(dto.getFechaSubida())
                .persona(personaOpt.get())
                .build();

        return entityToDto(documentosRepository.save(documento));
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentosDTO obtenerPorId(Long id) {
        return documentosRepository.findById(id)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public List<DocumentosDTO> listar() {
        return documentosRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DocumentosDTO actualizar(Long id, DocumentosDTO dto) {
        return documentosRepository.findById(id).map(documento -> {
            documento.setNombreArchivo(dto.getNombreArchivo());
            documento.setTipo(dto.getTipo());
            documento.setDescripcion(dto.getDescripcion());
            documento.setContenido(dto.getContenido());
            documento.setFechaSubida(dto.getFechaSubida());
            return entityToDto(documentosRepository.save(documento));
        }).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        documentosRepository.deleteById(id);
    }

    private DocumentosDTO entityToDto(Documentos doc) {
        return DocumentosDTO.builder()
                .id(doc.getId())
                .nombreArchivo(doc.getNombreArchivo())
                .tipo(doc.getTipo())
                .descripcion(doc.getDescripcion())
                .contenido(doc.getContenido())
                .fechaSubida(doc.getFechaSubida())
                .personaId(doc.getPersona().getId())
                .build();
    }
}
