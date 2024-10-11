package pl.kf.itjobsearcher.business.external.januszsoft.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class JanuszSoftClientConfig {
    @Bean
    public JanuszSoftClient januszSoftClient(){
        RestClient webClient = RestClient.builder()
                .baseUrl("localhost:3000")
                .build();
        return new JanuszSoftClient(webClient);
    }
}
