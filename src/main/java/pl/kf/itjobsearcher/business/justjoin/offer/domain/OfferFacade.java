package pl.kf.itjobsearcher.business.justjoin.offer.domain;

import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

import java.util.List;

public interface OfferFacade {
    OfferQuery findOfferById(Long id);
    List<OfferQuery> findAllOffers();

    void deleteOffer(Long id);
}
