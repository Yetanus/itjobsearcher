package pl.kf.itjobsearcher.business.offer.domain;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

import java.util.List;

public interface OfferFacade {

    void createOffer(List<CreateOfferCommand> createOfferCommands ,OfferSource offerSource);
    void updateOffer();
    OfferQuery findOfferById(Long id);
    List<OfferQuery> findAllOffers();

    void deleteOffer(Long id);
}
