package pl.kf.itjobsearcher.business.offer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.kf.itjobsearcher.business.offer.domain.OfferFacade;

@RestController
@RequestMapping("/offers")
@RequiredArgsConstructor
public class OfferRestController {

    private final OfferFacade offerFacade;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createOffer() {
        offerFacade.createOffer();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/offers/{id}")
    public void updateOffer(@PathVariable String id) {
        offerFacade.updateOffer();
    }

}
