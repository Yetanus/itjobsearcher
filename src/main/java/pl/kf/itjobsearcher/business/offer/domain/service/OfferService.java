package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.extern.slf4j.Slf4j;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferRepository;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;

@Slf4j
public record OfferService(
        OfferRepository offerRepository
) {

    public void createOffer(CreateOfferCommand createOfferCommand) {
        OfferEntity offerEntity = OfferEntity.builder()
                .description(createOfferCommand.description())
                .build();

        offerRepository.save(offerEntity);
    }
}
