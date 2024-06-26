package pl.kf.itjobsearcher.business.offer.dto.response;

import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

import java.util.UUID;

public record OfferResponse(
        UUID id,
        String description
) {

    public static OfferResponse fromQuery(OfferQuery offerQuery) {
        return new OfferResponse(
                offerQuery.uuid(),
                offerQuery.description()
        );
    }
}
