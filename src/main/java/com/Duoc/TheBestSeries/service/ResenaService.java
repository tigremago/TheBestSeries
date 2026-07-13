package com.Duoc.TheBestSeries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Duoc.TheBestSeries.dto.CantidaddevaloracionDTO;
import com.Duoc.TheBestSeries.dto.ResenaSerieDTO;
import com.Duoc.TheBestSeries.model.Resena;
import com.Duoc.TheBestSeries.model.Serie;
import com.Duoc.TheBestSeries.model.Usuario_Serie;
import com.Duoc.TheBestSeries.repository.ResenaRepository;

import com.Duoc.TheBestSeries.repository.SerieRepository;
import com.Duoc.TheBestSeries.repository.Usuario_serie_Repository;

@Service
public class ResenaService {
    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired 
    private Usuario_serie_Repository usuarioRepository;

    // crear una reseña
    public Resena guardarresenanueva(Resena resena) {

        if (resena.getUsuario() == null || resena.getSerie() == null) {
            throw new RuntimeException("Usuario o Serie no enviados");
        }

        Usuario_Serie usuario = usuarioRepository.findById(
                resena.getUsuario().getId_usuario()
        ).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Serie serie = serieRepository.findById(
                resena.getSerie().getId_serie()
        ).orElseThrow(() -> new RuntimeException("Serie no encontrada"));

        resena.setUsuario(usuario);
        resena.setSerie(serie);

        return resenaRepository.save(resena);
    }
    
    // mostrar todas las reseñas
    public List<Resena> mostrarresenas() {
        return resenaRepository.findAll();
    }

    public List<ResenaSerieDTO> resenaporserie(String nombreSerie){

        return resenaRepository.findAll()
                .stream()
                .filter(r -> r.getSerie() != null
                        && r.getSerie().getNombre() != null
                        && r.getSerie().getNombre().equalsIgnoreCase(nombreSerie))
                .map(resena -> {
                    ResenaSerieDTO dto = new ResenaSerieDTO();

                    dto.setId_resena(resena.getId_resena());
                    dto.setId_usuario(resena.getUsuario().getId_usuario());
                    dto.setNombre_serie(resena.getSerie().getNombre());
                    dto.setDescripcion(resena.getDescripcion());
                    dto.setEstrellas(resena.getEstrellas());

                    return dto;
                })
                .toList();
    }


    // eliminar una reseña
    public void eliminarresena(int id) {
        resenaRepository.deleteById(id);
    }

    // modificar una reseña
    public Resena updateResena(Resena resena) {
        if (!resenaRepository.existsById(resena.getId_resena())) {
            return null;
        }
        return resenaRepository.save(resena);
    }

    // mostrar la valoración de una serie (promedio de estrellas y cantidad de reseñas)
    public CantidaddevaloracionDTO valoracionserie(String nombre){
        List<Resena> resenas = resenaRepository.findAll().stream()
        .filter(r -> r.getSerie().getNombre().equalsIgnoreCase(nombre))
        .toList();

        int cantidadresenas = resenas.size();


        CantidaddevaloracionDTO dto = new CantidaddevaloracionDTO();
        double promedio = resenas.stream()
        .mapToInt(Resena::getEstrellas)
        .average()
        .orElse(0.0);

        dto.setNombre(nombre);
        dto.setEstrellas(promedio);
        dto.setCantidad(cantidadresenas);
        return dto;
            
    }

}
