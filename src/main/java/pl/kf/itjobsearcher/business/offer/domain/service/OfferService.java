package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.extern.slf4j.Slf4j;
import pl.kf.itjobsearcher.business.offer.domain.mapper.OfferMapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferRepository;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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

    public List<OfferQuery> findAllOffers(){
        return offerRepository.findAll()
                .stream()
                .map(OfferMapper::mapToOfferQuery)
                .filter(Objects::nonNull)
                .toList();
    }

    public void updateOffer(){
        OfferEntity offerEntity = OfferEntity.builder()
                .description("Mid C++ Developer")
                .build();

        offerRepository.save(offerEntity);
    }

}
