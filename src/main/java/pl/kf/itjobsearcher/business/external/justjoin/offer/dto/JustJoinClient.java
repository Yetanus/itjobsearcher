package pl.kf.itjobsearcher.business.external.justjoin.offer.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Class ,which uses WebClient to retrive data from JustJoinIT website.
 */
@Service
public class JustJoinClient {

    private final WebClient webClient;

    @Autowired
    public JustJoinClient(WebClient webClient){
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
        Mono<JustJoinOffer> offers = webClient
                .get()
                .uri("https://justjoin.it/")
                .retrieve()
                .bodyToMono(JustJoinOffer.class);
        return null;
    }

}
