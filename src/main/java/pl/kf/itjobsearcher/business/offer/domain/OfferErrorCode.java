package pl.kf.itjobsearcher.business.offer.domain;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherErrorCode;

@RequiredArgsConstructor
public enum OfferErrorCode implements ITJobSearcherErrorCode {
    //todo zrobic ta klase taka zeby byla bardziej generalna np. not found
    OFFER_NOT_FOUND("Offer with given id does not exists"),
    OFFER_NOT_UPDATED("Offer could not be updated"),
    OFFER_ALREADY_EXIST("Offer exist - could not be created"),
    OFFER_WRONG("Offer not created - wrong given data"),
    OFFER_NOT_DELETED("Offer could not be deleted");

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
