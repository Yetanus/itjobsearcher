package pl.kf.itjobsearcher.business.external.justjoin.dto;

import lombok.Builder;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferWrapper;

import java.util.List;

/**
 * Wrapper class for JustJoinIT
 */
@Builder
public record JustJoinOffersWrapper(
        List<JustJoinOffer> offers
) implements OfferWrapper<JustJoinOffer> {

}
