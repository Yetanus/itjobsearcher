package pl.kf.itjobsearcher.business.external.januszsoft.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import pl.kf.itjobsearcher.business.offer.dto.OfferClient;

import java.util.List;

/**
 * Class ,which uses {@link RestClient} to retrive data from JanuszSoft website.
 */
@RequiredArgsConstructor
public class JanuszSoftClient implements OfferClient {
    private final RestClient restClient;

    @Override
    public JanuszSoftOffersWrapper fetchOffers() {
        List<JanuszSoftOffer> offers = List.of();
        return JanuszSoftOffersWrapper.builder()
                .offers(offers)
                .build();
    }

    @Override
    public List<JanuszSoftOffer> getOffersFromWeb() {
        ResponseEntity<JanuszSoftOffer> offers = restClient
                .get()
                .uri("/")
                .retrieve()
                .toEntity(JanuszSoftOffer.class);
        return null;
    }
}
