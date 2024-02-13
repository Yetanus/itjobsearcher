package pl.kf.itjobsearcher.business.offer.domain;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherErrorCode;

@RequiredArgsConstructor
public enum TechnologyErrorCode implements ITJobSearcherErrorCode {

    TECHNOLOGY_NOT_FOUND("Technology does not exist");

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
