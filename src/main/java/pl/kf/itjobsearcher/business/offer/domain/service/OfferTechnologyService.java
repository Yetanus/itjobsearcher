package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferTechnologyEntity;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferTechnologyRepository;
import pl.kf.itjobsearcher.business.offer.dto.CreateTechnologyCommand;

@Slf4j
@RequiredArgsConstructor
public class OfferTechnologyService {
    private final OfferTechnologyRepository offerTechnologyRepository;

    public void createTechnology(CreateTechnologyCommand createTechnologyCommand) {
        OfferTechnologyEntity offerTechnologyEntity = OfferTechnologyEntity.builder()
                .technology(createTechnologyCommand.technology())
                .build();
        offerTechnologyRepository.save(offerTechnologyEntity);
    }
}
