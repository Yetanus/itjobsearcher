package pl.kf.itjobsearcher.business.external.nofluffjobs.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Configuration class for WebClient used for communication with noFluffJobs website.
 */
@Configuration
public class NoFluffWebConfig {

    @Bean
    public RestClient NoFluffClient(){
        RestClient webClient = RestClient.builder()
                .baseUrl("https://nofluffjobs.com/pl/")
                .build();
        return webClient;
    }
}
