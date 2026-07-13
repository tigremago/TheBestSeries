package com.Duoc.TheBestSeries.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;  

@Configuration
public class WebClientConfig {

    @Value("${api.tvmaze}")
    private String apiTvmaze;

    @Bean("ApiSerie")
    public WebClient webClient(){

        return WebClient.builder()
                .baseUrl(apiTvmaze)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
