package pl.kf.itjobsearcher.business.offer.domain;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferService;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferUploaderService;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;
import pl.kf.itjobsearcher.business.offer.dto.UploadOffersCommand;

import java.util.List;

@RequiredArgsConstructor
public class OfferFacadeAdapter implements OfferFacade {

    private final OfferService offerService;
    private final OfferUploaderService offerUploaderService;

    @Override
    public void createOffer(List<CreateOfferCommand> createOfferCommand, OfferSource offerSource) {
        offerService.createOffer(createOfferCommand, offerSource);
    }

    @Override
    public OfferQuery findOfferById(Long id) {
        return offerService.findOfferById(id);
    }

    @Override
    public List<OfferQuery> findAllOffers() {
        return offerService.findAllOffers();
    }

    @Override
    public void uploadOffers(UploadOffersCommand uploadOffersCommand) {
        offerUploaderService.uploadOffers(uploadOffersCommand);
    }
}
