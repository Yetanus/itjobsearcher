package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.extern.slf4j.Slf4j;
import pl.kf.itjobsearcher.business.offer.domain.mapper.OfferMapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferRepository;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

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

    public OfferQuery findOfferById(Long id) {
        return offerRepository.findById(id)
                .map(OfferMapper::mapToOfferQuery)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
    }
}
