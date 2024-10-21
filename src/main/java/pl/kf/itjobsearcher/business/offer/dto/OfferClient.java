package pl.kf.itjobsearcher.business.offer.dto;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferWrapper;

import java.util.List;

/**
 * The interface responsible for fetching offers from external providers
 */
public interface OfferClient<T> {

    /**
     * Return all offers from one of the external providers
     *
     * @return {@link OfferWrapper} with all offers from the external provider
     */
    OfferWrapper<T> fetchOffers();
}
