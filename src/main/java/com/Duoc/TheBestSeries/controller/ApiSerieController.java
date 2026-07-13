package com.Duoc.TheBestSeries.controller;

import com.Duoc.TheBestSeries.dto.SerieDTO;
import com.Duoc.TheBestSeries.service.ApiSerieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Externa")
public class ApiSerieController {

    @Autowired
    private ApiSerieService apiService;

    @GetMapping("/{nombre}")
    public ResponseEntity<SerieDTO> buscarSerie(@PathVariable String nombre){

        return ResponseEntity.ok(apiService.buscarSerie(nombre));
    }
}