package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.EstudianteDTO;
import com.ProyectoFinal.Trabajo_U.model.Estudiante;
import com.ProyectoFinal.Trabajo_U.repository.EstudianteRepository;
import com.ProyectoFinal.Trabajo_U.service.EstudianteService;
import com.lowagie.text.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.ByteArrayOutputStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Override
    @Transactional(readOnly = true)
    public byte[] generarReportePdf() throws DocumentException {
        List<EstudianteDTO> estudiantes = listar(); // Usamos tu método listar()

        Document document = new Document(PageSize.A4.rotate()); // Apaisado para más espacio
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();

        // Título
        Font fontTitulo = new Font(Font.HELVETICA, 18, Font.BOLD);
        Paragraph titulo = new Paragraph("Reporte de Estudiantes", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Tabla con columnas (igual que campos del DTO)
        PdfPTable tabla = new PdfPTable(12); // 12 columnas
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{2f, 3f, 3f, 3f, 2f, 2f, 3f, 4f, 3f, 3f, 3f, 1.5f});

        // Agregamos encabezados
        Stream.of("ID", "Nombres", "Apellido Paterno", "Apellido Materno", "CI", "Sexo",
                        "Fecha Nac.", "Correo", "Ciudad", "Teléfono", "Carrera", "Nivel")
                .forEach(headerTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(Color.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(headerTitle));
                    tabla.addCell(header);
                });

        // Agregar filas
        for (EstudianteDTO est : estudiantes) {
            tabla.addCell(String.valueOf(est.getId()));
            tabla.addCell(est.getNombres());
            tabla.addCell(est.getApellidoPaterno());
            tabla.addCell(est.getApellidoMaterno());
            tabla.addCell(est.getCi());
            tabla.addCell(est.getSexo());
            tabla.addCell(est.getFechaNacimiento() != null ? est.getFechaNacimiento().toString() : "");
            tabla.addCell(est.getCorreo());
            tabla.addCell(est.getCiudad());
            tabla.addCell(est.getTelefono());
            tabla.addCell(est.getCarrera());
            tabla.addCell(String.valueOf(est.getNivel()));
        }

        document.add(tabla);
        document.close();

        return baos.toByteArray();
    }
}
