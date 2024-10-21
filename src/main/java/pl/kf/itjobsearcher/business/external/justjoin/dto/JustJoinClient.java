package pl.kf.itjobsearcher.business.external.justjoin.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import pl.kf.itjobsearcher.business.offer.dto.OfferClient;

import java.util.List;

/**
 * Class ,which uses {@link RestClient} to retrive data from JustJoinIT website.
 */
@RequiredArgsConstructor
public class JustJoinClient implements OfferClient<JustJoinOffer> {

    private final RestClient restClient;

    public JustJoinOffersWrapper fetchOffers() {
        List<JustJoinOffer> offers = List.of();
        return JustJoinOffersWrapper.builder()
                .offers(offers)
                .build();
    }
}
