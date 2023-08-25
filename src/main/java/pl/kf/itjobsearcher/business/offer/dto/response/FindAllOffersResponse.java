package pl.kf.itjobsearcher.business.offer.dto.response;

import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

import java.util.List;

public record FindAllOffersResponse(
        long numberOfNumbers,
        List<OfferResponse> offers
) {

    public static FindAllOffersResponse fromQueries(List<OfferQuery> offerQueries) {
        List<OfferResponse> offerResponses = offerQueries.stream()
                .map(OfferResponse::fromQuery)
                .toList();

        return new FindAllOffersResponse(
                offerResponses.size(),
                offerResponses
        );
    }
}
