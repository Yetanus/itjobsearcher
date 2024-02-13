package pl.kf.itjobsearcher.business.offer.dto.response;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferTechnology;
import pl.kf.itjobsearcher.business.offer.dto.TechnologyQuery;

import java.util.UUID;

public record TechnologyResponse(
        UUID id,
        OfferTechnology technology
) {
    public static TechnologyResponse fromQuery(TechnologyQuery technologyQuery){
        return new TechnologyResponse(
                technologyQuery.id(),
                technologyQuery.technology()
        );
    }
}
