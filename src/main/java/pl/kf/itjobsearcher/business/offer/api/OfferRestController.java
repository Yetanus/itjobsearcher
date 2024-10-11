package pl.kf.itjobsearcher.business.offer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.kf.itjobsearcher.business.offer.domain.OfferFacade;
import pl.kf.itjobsearcher.business.offer.dto.request.UploadOfferRequest;
import pl.kf.itjobsearcher.business.offer.dto.response.FindAllOffersResponse;

@RestController
@RequestMapping("/offers")
@RequiredArgsConstructor
public class OfferRestController {

    private final OfferFacade offerFacade;

    @CrossOrigin(originPatterns = "localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public FindAllOffersResponse findAllOffers() {
        return FindAllOffersResponse.fromQueries(offerFacade.findAllOffers());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(value = "/uploads")
    public void uploadOffers(@RequestBody UploadOfferRequest uploadOfferRequest){
        offerFacade.uploadOffers(uploadOfferRequest.toUploadOffersRequest());
    }

}
