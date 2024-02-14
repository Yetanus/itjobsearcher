package pl.kf.itjobsearcher.business.offer.domain.mapper;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

public record OfferMapper() {

    public static OfferQuery mapToOfferQuery(OfferEntity offerEntity) {
        if (offerEntity == null) {
            return null;
        }
        return OfferQuery.builder()
                .id(offerEntity.getUuid())
                .description(offerEntity.getDescription())
                .build();
    }
    public static OfferQuery changeOfferQuery(OfferEntity offerEntity) {
        if (offerEntity.getDescription().equals("Java Developer"))
            return OfferQuery.builder()
                    .id(offerEntity.getUuid())
                    .description("Mid/Senior Java Developer")
                    .build();


        return OfferQuery.builder()
                .id(offerEntity.getUuid())
                .description(offerEntity.getDescription())
                .build();
    }
}
