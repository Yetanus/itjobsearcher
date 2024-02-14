package pl.kf.itjobsearcher.business.offer.dto.request;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferTechnology;
import pl.kf.itjobsearcher.business.offer.dto.CreateTechnologyCommand;

public record CreateTechnologyRequest(
        OfferTechnology technology
) {
    public CreateTechnologyCommand toCreateTechnologyCommand(){
        return CreateTechnologyCommand.builder()
                .technology(technology)
                .build();
    }
}
