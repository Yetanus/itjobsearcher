package pl.kf.itjobsearcher.business.offer.domain;

import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

public interface OfferFacade {

    void createOffer(CreateOfferCommand createOfferCommand);
    void updateOffer();
    OfferQuery findOfferById(Long id);
}
