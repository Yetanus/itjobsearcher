package pl.kf.itjobsearcher.business.external.januszsoft.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record JanuszSoftOffersWrapper(
        List<JanuszSoftOffer> offers
) { }
