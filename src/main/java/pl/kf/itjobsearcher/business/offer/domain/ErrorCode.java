package pl.kf.itjobsearcher.business.offer.domain;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherErrorCode;

@RequiredArgsConstructor
public enum ErrorCode implements ITJobSearcherErrorCode {
    NOT_FOUND("Element with given id does not exists"),
    NOT_UPDATED("Could not be updated"),
    ALREADY_EXIST("Already exist - could not be created"),
    NOT_CREATED_WRONG_INPUT("Not created - wrong given data"),
    NOT_DELETED("Could not be deleted");

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
