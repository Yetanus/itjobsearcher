package pl.kf.itjobsearcher.business.offer.domain;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherErrorCode;

@RequiredArgsConstructor
public enum OfferErrorCode implements ITJobSearcherErrorCode {

    OFFER_NOT_FOUND("Offer with given id does not exists");

    private final String description;

    @Override
    public String code() {
        return name();
    }

    @Override
    public String description() {
        return description;
    }
}
