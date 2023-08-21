package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;

@Builder
public record CreateOfferCommand(
        String description
) { }
