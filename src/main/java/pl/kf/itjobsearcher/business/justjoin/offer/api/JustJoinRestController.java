package pl.kf.itjobsearcher.business.justjoin.offer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.kf.itjobsearcher.business.offer.domain.OfferFacade;
import pl.kf.itjobsearcher.business.offer.dto.response.FindAllOffersResponse;
import pl.kf.itjobsearcher.business.offer.dto.response.OfferResponse;

@RestController
@RequestMapping("/jj")
@RequiredArgsConstructor
public class JustJoinRestController {
    private final OfferFacade offerFacade;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OfferResponse findOfferById(@PathVariable("id") Long id) {
        return OfferResponse.fromQuery(offerFacade.findOfferById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/offers", produces = MediaType.APPLICATION_JSON_VALUE)
    public FindAllOffersResponse findAllOffers() {
        return FindAllOffersResponse.fromQueries(offerFacade.findAllOffers());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/offers/{id}")
    public void deleteOffer(@PathVariable("id") Long id)
    {
        offerFacade.deleteOffer(id);
    }
}
