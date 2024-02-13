package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record TechnologyQuery(
        UUID id,
        String technology
) {
}
