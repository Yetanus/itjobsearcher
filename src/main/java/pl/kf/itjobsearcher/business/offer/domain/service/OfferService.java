package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import pl.kf.itjobsearcher.business.offer.domain.OfferErrorCode;
import pl.kf.itjobsearcher.business.offer.domain.mapper.OfferMapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferRepository;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherBusinessException;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherErrorCode;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    public void createOffer(CreateOfferCommand createOfferCommand) {
        OfferEntity offerEntity = OfferEntity.builder()
                .description(createOfferCommand.description())
                .build();
        offerRepository.save(offerEntity);
    }

    public OfferQuery findOfferById(Long id) {
        return offerRepository.findById(id)
                .map(OfferMapper::mapToOfferQuery)
                .orElseThrow(() -> new ITJobSearcherBusinessException(OfferErrorCode.OFFER_NOT_FOUND, "Offer with given id not found"));
    }

    public List<OfferQuery> findAllOffers(){
        return offerRepository.findAll()
                .stream()
                .map(OfferMapper::mapToOfferQuery)
                .filter(Objects::nonNull)
                .toList();
    }

    public void updateOffer(){
        offerRepository.findAll()
                .stream()
                .map(OfferMapper::changeOfferQuery);

    }

    public void deleteOffer(Long id)
    {
        OfferEntity offerEntity = OfferEntity.builder().build();
        offerRepository.delete(offerEntity);
    }

}
