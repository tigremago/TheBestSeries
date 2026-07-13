package com.Duoc.TheBestSeries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Duoc.TheBestSeries.model.Resena;
import com.Duoc.TheBestSeries.model.Serie;
import com.Duoc.TheBestSeries.service.SerieService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    private SerieService serieservice;

    // crear serie
    @PostMapping
    public ResponseEntity<Serie> crearserie(@Valid @RequestBody Serie serie){
        System.out.println("[SerieController] -> crearserie");
        return ResponseEntity.status(HttpStatus.CREATED).body(serieservice.crearserie(serie));
    }
    

    // mostrar todas las series
    @GetMapping
    public ResponseEntity<List<Serie>> mostrarseries(){
        System.out.println("Mostrando todas las series");
        List<Serie> series = serieservice.mostrarseries();
        return ResponseEntity.ok(series);
    }

    // mostrar serie por id 
    @GetMapping("/{id}")
    public ResponseEntity<Serie> mostrarporid(@PathVariable int id){
        Serie serie = serieservice.mostrarporid(id);
        return ResponseEntity.ok(serie);
    }

    // actualizar serie
    @PutMapping
    public ResponseEntity<Serie> actualizarserie(@Valid @RequestBody Serie serie){
        System.out.println("Actualizando serie");
        Serie actualizandoserie = serieservice.updateserie(serie);
        return ResponseEntity.ok(actualizandoserie);
    }

    // eliminar serie
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarserie(@PathVariable int id){
        System.out.println("Eliminando serie");
        serieservice.eliminarserie(id);
        return ResponseEntity.ok("Serie eliminada con exito");
    }

    // buscar serie por actor
    @GetMapping("/actor/{actor}")
    public ResponseEntity<List<Serie>> buscarporactor(@PathVariable String actor){
        System.out.println("Buscando series por actor");
        List<Serie> series = serieservice.getserieporactor(actor);
        return ResponseEntity.ok(series);
    }

    // buscar series por año de publicacion
    @GetMapping("/anio/{publicacion}")
    public ResponseEntity<List<Serie>> buscarporaniodepublicacion(@PathVariable int publicacion){
        System.out.println("Buscando series por año de publicacion");
        List<Serie> series = serieservice.getserieporaniopublicacion(publicacion);
        return ResponseEntity.ok(series);
    }

    // mostrar reseñas de una serie
    @GetMapping("/Serie/{nombre}")
    public ResponseEntity<List<Resena>> mostrarresenasdeunaserie(@RequestBody Serie serie){
        System.out.println("Mostrando reseñas por serie");
        List<Resena> resenas = serieservice.getresenasdeserie(serie);
        return ResponseEntity.ok(resenas);
    }

}


