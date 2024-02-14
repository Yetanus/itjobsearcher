package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferTechnology;

@Builder
public record CreateTechnologyCommand(
        OfferTechnology technology
) {}
