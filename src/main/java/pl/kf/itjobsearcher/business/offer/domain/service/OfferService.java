package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.extern.slf4j.Slf4j;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferRepository;

@Slf4j
public record OfferService(
        OfferRepository offerRepository
) {

    public void createOffer() {
        OfferEntity offerEntity = OfferEntity.builder()
                .description("Senior Java Developer")
                .build();

        offerRepository.save(offerEntity);
    }
}
