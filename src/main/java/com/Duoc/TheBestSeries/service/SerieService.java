package com.Duoc.TheBestSeries.service;

import com.Duoc.TheBestSeries.model.Resena;
import com.Duoc.TheBestSeries.model.Serie;
import com.Duoc.TheBestSeries.repository.SerieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;

    // crear una serie
    public Serie crearserie(Serie serie){
        return serieRepository.save(serie);
    }

    // mostrar todas las series
    public List<Serie> mostrarseries(){
        return serieRepository.findAll();
    }

    // mostrar una serie por su id
    public Serie mostrarporid(int id){
        return serieRepository.findById(id).orElse(null);
    }

    // eliminar una serie
    public void eliminarserie(int id){
        serieRepository.deleteById(id);
    }

    // modificar una serie
    public Serie updateserie(Serie serie){
        if(!serieRepository.existsById(serie.getId_serie())){
            return null;
        }
        return serieRepository.save(serie);
    }

    // mostrar serie por actores
    public List<Serie> getserieporactor(String actor){
        return serieRepository.findAll().stream()
        .filter(s -> s.getReparto().contains(actor))
        .toList();
    }

    // mostrar serie por año de publicacion
    public List<Serie> getserieporaniopublicacion(int publicacion){
        return serieRepository.findAll().stream().filter(s ->
        s.getAnio_publicacion() == publicacion)
        .toList();
    }

    // mostrar todas las resenas de una serie
    public List<Resena> getresenasdeserie(Serie serie){
        return serieRepository.findById(serie.getId_serie())
        .map(s -> s.getResenas())
        .orElse(null);
    }


}
