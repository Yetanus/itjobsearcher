package pl.kf.itjobsearcher.business.external.justjoin.offer.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for WebClient used for communication with JustJoinIT website.
 */
@Configuration
public class JustJoinWebConfig {
    @Bean
    public WebClient webClient(){
        WebClient webClient = WebClient.builder()
                .baseUrl("https://justjoin.it/")
                .defaultCookie("cookie-name", "cookie-value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
