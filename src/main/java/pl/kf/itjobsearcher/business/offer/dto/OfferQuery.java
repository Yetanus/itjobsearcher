package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record OfferQuery(
        UUID id,
        String description
) { }
