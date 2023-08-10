package pl.kf.itjobsearcher.business.offer.domain;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferService;

@RequiredArgsConstructor
public class OfferFacadeAdapter implements OfferFacade {

    private final OfferService offerService;

    @Override
    public void createOffer() {
        offerService.createOffer();
    }

    @Override
    public void updateOffer(){offerService.updateOffer();}


}
