package pl.kf.itjobsearcher.business.external.justjoin.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * Class ,which uses {@link RestClient} to retrive data from JustJoinIT website.
 */
@Service
public class JustJoinClient {

    private final RestClient webClient;

    @Autowired
    public JustJoinClient(RestClient webClient){
        this.webClient = webClient;
    }
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

    private List<JustJoinOffer> getOffersFromWeb(){
        ResponseEntity<JustJoinOffer> offers = webClient
                .get()
                .uri("/all-locations/java")
                .retrieve()
                .toEntity(JustJoinOffer.class);
        return null;
    }

}
