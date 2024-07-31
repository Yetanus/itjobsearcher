package pl.kf.itjobsearcher.business.external.januszsoft.dto;

import lombok.Builder;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferWrapper;

import java.util.List;

/**
 * Wrapper Class for Janusz Soft Offers.
 */
@Builder
public record JanuszSoftOffersWrapper (
        List<JanuszSoftOffer> offers
) implements OfferWrapper<JanuszSoftOffer> { }
