    package com.Duoc.TheBestSeries.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "series")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

    @OneToMany(mappedBy = "serie")
    @JsonIgnore
    private List<Resena> resenas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_serie;

    @NotBlank
    @NotNull
    private String nombre;

    @NotNull
    private Integer anio_publicacion;

    @NotNull
    private Integer anio_termino;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String sinopsis;

    @NotBlank
    @NotNull
    private String pais_origen;

    @ElementCollection
    private List<String> reparto;

    @NotNull
    private Integer duracion;

    @NotNull
    private Integer episodios;

    
}
