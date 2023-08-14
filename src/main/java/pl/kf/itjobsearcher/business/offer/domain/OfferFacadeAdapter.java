package pl.kf.itjobsearcher.business.offer.domain;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferService;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;

@RequiredArgsConstructor
public class OfferFacadeAdapter implements OfferFacade {

    private final OfferService offerService;

    @Override
    public void createOffer(CreateOfferCommand createOfferCommand) {
        offerService.createOffer(createOfferCommand);
    }
}
