package pl.kf.itjobsearcher.business.offer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferService;

@Configuration
public class OfferConfig {

    @Bean
    public OfferFacade offerFacade() {
        OfferService offerService = new OfferService();

        return new OfferFacadeAdapter(
                offerService
        );
    }
}
