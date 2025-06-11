package com.ProyectoFinal.Trabajo_U.service.impl;

import com.ProyectoFinal.Trabajo_U.dto.ConvocatoriasDTO;
import com.ProyectoFinal.Trabajo_U.model.Convocatorias;
import com.ProyectoFinal.Trabajo_U.repository.ConvocatoriasRepository;
import com.ProyectoFinal.Trabajo_U.service.ConvocatoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lowagie.text.Font;
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
    @Override
    @Transactional(readOnly = true)
    public byte[] generarReportePdf() throws DocumentException {
        List<ConvocatoriasDTO> convocatorias = listar();

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();

        Font fontTitulo = new Font(Font.HELVETICA, 18, Font.BOLD);
        Paragraph titulo = new Paragraph("Reporte de Convocatorias", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        PdfPTable tabla = new PdfPTable(5); // Cantidad de columnas en ConvocatoriasDTO
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{1.5f, 4f, 8f, 3f, 3f});

        // Encabezados
        Stream.of("ID", "Título", "Descripción", "Fecha Publicación", "Fecha Cierre")
                .forEach(header -> {
                    PdfPCell celda = new PdfPCell();
                    celda.setBackgroundColor(Color.LIGHT_GRAY);
                    celda.setBorderWidth(1);
                    celda.setPhrase(new Phrase(header));
                    tabla.addCell(celda);
                });

        // Contenido
        for (ConvocatoriasDTO c : convocatorias) {
            tabla.addCell(String.valueOf(c.getId()));
            tabla.addCell(c.getTitulo());
            tabla.addCell(c.getDescripcion());
            tabla.addCell(c.getFechaPublicacion() != null ? c.getFechaPublicacion().toString() : "");
            tabla.addCell(c.getFechaCierre() != null ? c.getFechaCierre().toString() : "");
        }

        document.add(tabla);
        document.close();

        return baos.toByteArray();
    }
}
