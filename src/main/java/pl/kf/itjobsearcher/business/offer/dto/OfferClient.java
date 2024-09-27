package pl.kf.itjobsearcher.business.offer.dto;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferWrapper;

import java.util.List;

public interface OfferClient {
    OfferWrapper fetchOffers();
     List<?> getOffersFromWeb();
}
