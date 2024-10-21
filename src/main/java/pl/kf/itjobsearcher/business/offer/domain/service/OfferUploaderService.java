package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftClient;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinClient;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferWrapper;
import pl.kf.itjobsearcher.business.offer.dto.OfferClient;
import pl.kf.itjobsearcher.business.offer.dto.UploadOffersCommand;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class OfferUploaderService {

    private final OfferService offerService;
    private final JustJoinClient justJoinClient;
    private final JanuszSoftClient januszSoftClient;

    // Może rozszerzyc ta mape ?
    private final Map<OfferSource, OfferClient<?>> offerClients;

    /**
     * Method uploads offers to database.
     * @param uploadOffersCommand - command with source of offers.
     */
    public void uploadOffers(UploadOffersCommand uploadOffersCommand) {
        OfferSource offerSource = uploadOffersCommand.offerSource();
        OfferClient<?> offerClient = offerClients.get(offerSource);
        if (offerClient == null) {
            throw new IllegalArgumentException("Client for the given offer source is not available");
        }
        OfferWrapper<?> offerWrapper = offerClient.fetchOffers();
        List<?> offers = offerWrapper.offers(); // => List<CreateOfferCommand>

        // Call createOffers with right list of offers is main goal of this method
        offerService.createOffers(List.of(), offerSource);
    }
}
