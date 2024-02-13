package pl.kf.itjobsearcher.business.offer.domain.mapper;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferTechnologyEntity;
import pl.kf.itjobsearcher.business.offer.dto.TechnologyQuery;

public record TechnologyMapper() {
    public static TechnologyQuery mapToTechnologyQuery(OfferTechnologyEntity offerTechnologyEntity)
    {
        if(offerTechnologyEntity == null){
            return null;
        }
        return TechnologyQuery.builder()
                .id(offerTechnologyEntity.getUuid())
                .technology(offerTechnologyEntity.getTechnology())
                .build();
    }
}
