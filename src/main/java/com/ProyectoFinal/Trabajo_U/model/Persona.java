package com.ProyectoFinal.Trabajo_U.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;

    @Column(nullable = false, length = 50)
    @Length(min = 3, max = 50)
    @Basic(optional = false)
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, length = 50)
    @Length(min = 3, max = 50)
    @Basic(optional = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 50)
    @Length(min = 3, max = 50)
    @Basic(optional = false)
    private String apellidoMaterno;

    @Column(name = "ci", nullable = false, unique = true, length = 20)
    @NotBlank
    private String ci;

    @Column(nullable = false, length = 10)
    @Pattern(regexp = "^(Masculino|Femenino)$", message = "Debe ser Masculino o Femenino")
    private String sexo;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Basic(optional = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, unique = true, length = 100)
    @Email
    private String correo;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String ciudad;

    @Column(length = 20)
    private String telefono;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postulacion> postulaciones;

    @Version
    private Integer version;
}
