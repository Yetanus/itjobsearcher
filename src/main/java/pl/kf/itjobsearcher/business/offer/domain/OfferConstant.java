package pl.kf.itjobsearcher.business.offer.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OfferConstant {

    public static final int MIN_REQUIRED_EXPERIENCE_IN_YEARS = 0;
    public static final int MAX_REQUIRED_EXPERIENCE_IN_YEARS = 30;
    public static final int MAX_TITLE_LENGTH = 255;
}
