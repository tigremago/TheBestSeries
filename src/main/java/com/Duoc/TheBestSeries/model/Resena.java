package com.Duoc.TheBestSeries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resenas")
public class Resena { 

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario_Serie usuario;

    @ManyToOne   
    @JoinColumn(name = "id_serie")
    private Serie serie;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_resena;

    @NotBlank
    @NotNull
    private String descripcion;

    @NotNull
    private Integer estrellas;


    @NotNull
    private Integer valoracion;


    @Override
    public String toString() {
        return "Resena{" +
                "id_resena=" + id_resena +
                ", id_usuario=" + usuario.getId_usuario() +
                ", nombre_serie=" + serie.getNombre() +
                ", descripcion='" + descripcion + '\'' +
                ", estrellas=" + estrellas +
                '}';
    }
}

