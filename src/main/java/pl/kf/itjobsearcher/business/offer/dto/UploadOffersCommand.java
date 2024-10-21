package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;

@Builder
public record UploadOffersCommand(
        OfferSource offerSource
) { }
