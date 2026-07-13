package com.Duoc.TheBestSeries.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data; 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CantidaddevaloracionDTO {

    private String nombre;
    private int cantidad;
    private double estrellas;
}
