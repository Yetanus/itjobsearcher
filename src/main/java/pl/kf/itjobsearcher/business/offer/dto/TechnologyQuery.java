package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferTechnology;

import java.util.UUID;

@Builder
public record TechnologyQuery(
        UUID id,
        OfferTechnology technology
) {
}
