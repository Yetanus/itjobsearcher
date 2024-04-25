package pl.kf.itjobsearcher.business.external.justjoin.offer.dto;

import java.util.List;

public class JustJoinClient {

    /**
     * This method is responsible for fetch all offers from JustJointIT job board.
     *
     * @return {@link JustJoinOffersWrapper} that contains all offers available on JustJoinIT job board
     */
    public JustJoinOffersWrapper fetchOffers() {
        List<JustJoinOffer> offers = List.of();
        return JustJoinOffersWrapper.builder()
                .offers(offers)
                .build();
    }
}
