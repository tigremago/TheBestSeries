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

import com.Duoc.TheBestSeries.dto.CantidaddevaloracionDTO;
import com.Duoc.TheBestSeries.dto.ResenaSerieDTO;
import com.Duoc.TheBestSeries.model.Resena;
import com.Duoc.TheBestSeries.service.ResenaService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaservice;
    // crear una resena
    @PostMapping
    public ResponseEntity<Resena> crearresena(@Valid @RequestBody Resena resena){
        System.out.println("[ResenaCrontroller] -> CreandoReseña");
        return ResponseEntity.status(HttpStatus.CREATED).body(resenaservice.guardarresenanueva(resena));
    }

    // mostrar todas las resenas
    @GetMapping
    public ResponseEntity<List<Resena>> mostrartodaslasresenas(){
        System.out.println("Mostrando todas las reseñas");
        List<Resena> resenas = resenaservice.mostrarresenas();
        return ResponseEntity.ok(resenas);
    }

    // eliminar una reseña
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarresena(@PathVariable int id){
        System.out.println("Eliminando reseña");
        resenaservice.eliminarresena(id);
        return ResponseEntity.ok("Resena eliminada con exito");
    }

    // modificar una reseeña
    @PutMapping
    public ResponseEntity<Resena> actualizarreseña(@Valid @RequestBody Resena resena){
        System.out.println("Actualizando reseña");
        Resena actualizar = resenaservice.updateResena(resena);
        return ResponseEntity.ok(actualizar);
    }

    // mostrar la valoracion de una serie en terminos de reseñas
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<CantidaddevaloracionDTO> mostrarvaloracion(@PathVariable String nombre){
        System.out.println("Mostrando valoracion de una serie");
        CantidaddevaloracionDTO valoracion = resenaservice.valoracionserie(nombre);
        return ResponseEntity.ok(valoracion);
    }

    // mostrar reseñas por serie
    @GetMapping("/serie/{serie}")
    public ResponseEntity<List<ResenaSerieDTO>> mostrarresenas(@PathVariable String serie){

        System.out.println("Mostrando reseñas por serie");

        List<ResenaSerieDTO> series = resenaservice.resenaporserie(serie);

        return ResponseEntity.ok(series);
    }

}
