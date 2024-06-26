package pl.kf.itjobsearcher.business.external.justjoin.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Configuration class for {@link RestClient} used for communication with JustJoinIT website.
 */
@Configuration
public class JustJoinWebConfig {
    @Bean
    public RestClient JustJoinWebClient(){
        RestClient webClient = RestClient.builder()
                .baseUrl("https://justjoin.it/")
                .build();
        return webClient;
    }
}
