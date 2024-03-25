package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.kf.itjobsearcher.business.offer.domain.ErrorCode;
import pl.kf.itjobsearcher.business.offer.domain.mapper.OfferMapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferRepository;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherBusinessException;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    //todo modyfikacja do formy createOffers, parametr list<createoffercommand> najlepiej z enumem skad to pochodzi
    public void createOffer(CreateOfferCommand createOfferCommand) {
        //todo z listy liste encji i save all
        OfferEntity offerEntity = OfferEntity.builder()
                .description(createOfferCommand.description())
                .build();
        offerRepository.save(offerEntity);
    }

    public OfferQuery findOfferById(Long id) {
        return offerRepository.findById(id)
                .map(OfferMapper::mapToOfferQuery)
                .orElseThrow(() -> new ITJobSearcherBusinessException(ErrorCode.NOT_FOUND, "Offer with given id not found"));
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
