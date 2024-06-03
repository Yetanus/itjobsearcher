package pl.kf.itjobsearcher.business.external.januszsoft.dto;

import lombok.Builder;

import java.util.List;

/**
 * Wrapper Class for Janusz Soft Offers.
 */
@Builder
public record JanuszSoftOffersWrapper(
        List<JanuszSoftOffer> offers
) { }
