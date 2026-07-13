package com.Duoc.TheBestSeries.service;

import com.Duoc.TheBestSeries.dto.SerieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiSerieService {

    @Autowired
    @Qualifier("ApiSerie")
    private WebClient webClient;

    public SerieDTO buscarSerie(String nombre){

        return webClient.get()
                .uri("/singlesearch/shows?q=" + nombre)
                .retrieve()
                .bodyToMono(SerieDTO.class)
                .block();
    }
}