package pl.kf.itjobsearcher.business.offer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
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
                                    JustJoinClient justJoinClient) {
        OfferService offerService = new OfferService(
                offerRepository
        );
        Map<OfferSource, ? extends OfferConverter<? extends Record>> offerConverterMap = Map.of(
                OfferSource.JUST_JOIN, new JustJoinToOfferConverter(),
                OfferSource.JANUSZ_SOFT, new JanuszSoftOfferConverter());
        OfferUploaderService offerUploaderService = new OfferUploaderService(offerService,justJoinClient, offerConverterMap);
        //TODO pamietac o nullu
        return new OfferFacadeAdapter(offerService, null);
    }
}
