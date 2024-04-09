package pl.kf.itjobsearcher.business.external.justjoin.offer.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record JustJoinOffersWrapper(
        List<JustJoinOffer> offers
) {
}
