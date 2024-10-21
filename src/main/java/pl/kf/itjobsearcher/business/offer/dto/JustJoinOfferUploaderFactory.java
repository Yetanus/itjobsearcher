package pl.kf.itjobsearcher.business.offer.dto;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinClient;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinOffersWrapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferService;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.OfferConverter;

import java.util.List;

@RequiredArgsConstructor
public class JustJoinOfferUploaderFactory implements OfferFactory {
    private final OfferService offerService;
    private final JustJoinClient justJoinClient;
    private final OfferConverter<JustJoinOffersWrapper> justJoinOfferConverter;
    private final JustJoinOffersWrapper justJoinOffersWrapper;

    @Override
    public void uploadOffer() {
        List<CreateOfferCommand> createOfferCommand = justJoinOfferConverter.convert(justJoinOffersWrapper);
        offerService.createOffers(createOfferCommand, OfferSource.JANUSZ_SOFT);
        justJoinClient.fetchOffers();
    };

}
