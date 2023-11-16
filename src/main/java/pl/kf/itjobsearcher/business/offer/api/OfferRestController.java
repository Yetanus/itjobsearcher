package pl.kf.itjobsearcher.business.offer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kf.itjobsearcher.business.offer.domain.OfferFacade;
import pl.kf.itjobsearcher.business.offer.dto.request.CreateOfferRequest;
import pl.kf.itjobsearcher.business.offer.dto.response.FindAllOffersResponse;
import pl.kf.itjobsearcher.business.offer.dto.response.OfferResponse;

@RestController
@RequestMapping("/offers")
@RequiredArgsConstructor
public class OfferRestController {

    private final OfferFacade offerFacade;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OfferResponse findOfferById(@PathVariable("id") Long id) {
        return OfferResponse.fromQuery(offerFacade.findOfferById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOffer(@RequestBody CreateOfferRequest createOfferRequest) {
        offerFacade.createOffer(createOfferRequest.toCreateOfferCommand());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/offers", produces = MediaType.APPLICATION_JSON_VALUE)
    public FindAllOffersResponse findAllOffers() {
        return FindAllOffersResponse.fromQueries(offerFacade.findAllOffers());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/offers/{id}")
    public void updateOffer(@PathVariable String id) {
        offerFacade.updateOffer();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/offers/{id}")
    public void deleteOffer(@PathVariable("id") Long id)
    {
        offerFacade.deleteOffer(id);
    }

}
