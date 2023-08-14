package pl.kf.itjobsearcher.business.offer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.kf.itjobsearcher.business.offer.domain.OfferFacade;
import pl.kf.itjobsearcher.business.offer.dto.request.CreateOfferRequest;
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
}
