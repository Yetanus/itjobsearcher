package pl.kf.itjobsearcher.business.offer.dto.request;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.dto.UploadOffersCommand;

public record UploadOfferRequest(
        OfferSource offerSource
) {
    public UploadOffersCommand toUploadOffersRequest(){
        return UploadOffersCommand.builder()
                .offerSource(offerSource)
                .build();
    }
}
