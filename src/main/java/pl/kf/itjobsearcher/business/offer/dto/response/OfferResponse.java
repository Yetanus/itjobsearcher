package pl.kf.itjobsearcher.business.offer.dto.response;

import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

public record OfferResponse(
        Long id,
        String description
) {

    public static OfferResponse fromQuery(OfferQuery offerQuery) {
        return new OfferResponse(
                offerQuery.id(),
                offerQuery.description()
        );
    }
}
