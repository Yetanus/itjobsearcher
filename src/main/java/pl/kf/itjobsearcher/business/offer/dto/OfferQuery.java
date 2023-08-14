package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;

@Builder
public record OfferQuery(
        Long id,
        String description
) { }
