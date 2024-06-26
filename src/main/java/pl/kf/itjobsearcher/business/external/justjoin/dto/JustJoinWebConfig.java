package pl.kf.itjobsearcher.business.external.justjoin.offer.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Configuration class for WebClient used for communication with JustJoinIT website.
 */
@Configuration
public class JustJoinWebConfig {
    @Bean
    public RestClient webClient(){
        RestClient webClient = RestClient.builder()
                .baseUrl("https://justjoin.it/")
                .build();
        return webClient;
    }
}
