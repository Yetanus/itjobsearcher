package pl.kf.itjobsearcher.business.offer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClient;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftClient;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftOffersWrapper;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinClient;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferRepository;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferService;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferUploaderService;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.JanuszSoftOfferConverter;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.JustJoinToOfferConverter;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.OfferConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class OfferConfig {

    @Bean
    public OfferFacade offerFacade(OfferRepository offerRepository,
                                   JustJoinClient justJoinClient,
                                   JanuszSoftClient januszSoftClient)
                                      {
        OfferService offerService = new OfferService(
                offerRepository
        );

        OfferUploaderService offerUploaderService = new OfferUploaderService(offerService, justJoinClient, januszSoftClient);
        return new OfferFacadeAdapter(offerService, offerUploaderService);
    }
}
