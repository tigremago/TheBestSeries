package com.Duoc.TheBestSeries.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResenaSerieDTO {
    private String nombre_serie;
    private int  id_resena;
    private String descripcion;
    private int estrellas;
    private int id_usuario;
}

