package pl.kf.itjobsearcher.business.offer.domain;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;
import pl.kf.itjobsearcher.business.offer.dto.UploadOffersCommand;

import java.util.List;

public interface OfferFacade {

    void createOffers(List<CreateOfferCommand> createOfferCommands ,OfferSource offerSource);
    OfferQuery findOfferById(Long id);
    List<OfferQuery> findAllOffers();

    void uploadOffers(UploadOffersCommand uploadOffersCommand);

}
