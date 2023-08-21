package pl.kf.itjobsearcher.business.offer.domain.mapper;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

public record OfferMapper() {

    public static OfferQuery mapToOfferQuery(OfferEntity offerEntity) {
        return OfferQuery.builder()
                .id(offerEntity.getId())
                .description(offerEntity.getDescription())
                .build();
    }
}
