package com.Duoc.TheBestSeries.model;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios_Serie")
public class Usuario_Serie {

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Resena> resenas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @NotBlank
    @NotNull
    private String nombre_usuario;

    @NotNull
    private Integer anio_ingreso;
    
}
