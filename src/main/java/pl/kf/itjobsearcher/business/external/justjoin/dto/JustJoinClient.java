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
public class JustJoinClient implements OfferClient {

    private final RestClient restClient;

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

    public List<JustJoinOffer> getOffersFromWeb(){
        ResponseEntity<JustJoinOffer> offers = restClient
                .get()
                .uri("/")
                .retrieve()
                .toEntity(JustJoinOffer.class);
        return null;
    }

}
