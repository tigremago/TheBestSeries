package com.Duoc.TheBestSeries.controller;

import com.Duoc.TheBestSeries.model.Serie;
import com.Duoc.TheBestSeries.service.SerieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SerieControllerTest {

    @Mock
    private SerieService serieservice;

    @InjectMocks
    private SerieController seriecontroller;

    @Test
    void crearserie_retorno201(){
        Serie serie = new Serie();
        serie.setId_serie(1);
        serie.setNombre("Breaking Bad");
        serie.setAnio_publicacion(2008);
        serie.setAnio_termino(2013);
        serie.setSinopsis("Un profesor de química se convierte en fabricante de metanfetaminas.");
        serie.setPais_origen("Estados Unidos");
        serie.setDuracion(47);
        serie.setEpisodios(62);

        when(serieservice.crearserie(serie)).thenReturn(serie);

        var respuesta = seriecontroller.crearserie(serie);

        assertNotNull(respuesta);

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
        
        var body = respuesta.getBody();
        assertNotNull(body);

        assertEquals(serie.getId_serie(), body.getId_serie());


    }

    @Test 
    void buscar_serie_retorno200(){
        Serie serie = new Serie();
        serie.setId_serie(1);

        when(serieservice.mostrarporid(1)).thenReturn(serie);

        var respuesta = seriecontroller.mostrarporid(1);

        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        assertNotNull(respuesta.getBody());
        assertEquals(1, respuesta.getBody().getId_serie());

    }

    @Test
    void actualizar_serie_retorno200(){
        Serie serie = new Serie();

        serie.setId_serie(1);

        serie.setNombre("Breaking bad actualizada");

        when(serieservice.updateserie(serie)).thenReturn(serie);
        
        var respuesta = seriecontroller.actualizarserie(serie);

        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        assertNotNull(respuesta.getBody());
        assertEquals("Breaking bad actualizada", respuesta.getBody().getNombre());


    }


    @Test
    void eliminar_serie_retorno200(){

        var respuesta = seriecontroller.eliminarserie(1);

        verify(serieservice).eliminarserie(1);

        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        assertNotNull(respuesta.getBody());
        assertEquals("Serie eliminada con exito", respuesta.getBody());
    }
}