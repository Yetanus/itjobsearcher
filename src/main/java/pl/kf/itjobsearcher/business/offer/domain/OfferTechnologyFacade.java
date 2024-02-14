package pl.kf.itjobsearcher.business.offer.domain;

import pl.kf.itjobsearcher.business.offer.dto.CreateTechnologyCommand;

public interface OfferTechnologyFacade {
    void createTechnology(CreateTechnologyCommand createTechnologyCommand);
}
