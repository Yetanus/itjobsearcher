package pl.kf.itjobsearcher.business.offer.domain;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferTechnologyService;
import pl.kf.itjobsearcher.business.offer.dto.CreateTechnologyCommand;

@RequiredArgsConstructor
public class OfferTechnologyAdapter implements OfferTechnologyFacade {
    private final OfferTechnologyService offerTechnologyService;

    @Override
    public void createTechnology(CreateTechnologyCommand createTechnologyCommand) {
        offerTechnologyService.createTechnology(createTechnologyCommand);
    }
}
