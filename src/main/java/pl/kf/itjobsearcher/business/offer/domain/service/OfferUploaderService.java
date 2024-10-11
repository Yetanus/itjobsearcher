package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftClient;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftOffersWrapper;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinClient;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinOffersWrapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.JanuszSoftOfferConverter;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.JustJoinToOfferConverter;
import pl.kf.itjobsearcher.business.offer.dto.JanuszSoftOfferUploaderFactory;
import pl.kf.itjobsearcher.business.offer.dto.JustJoinOfferUploaderFactory;
import pl.kf.itjobsearcher.business.offer.dto.OfferFactory;
import pl.kf.itjobsearcher.business.offer.dto.UploadOffersCommand;

import java.util.List;

@RequiredArgsConstructor
public class OfferUploaderService {
    private final OfferService offerService;
    private final JustJoinClient justJoinClient;
    private final JanuszSoftClient januszSoftClient;
    private OfferFactory offerFactory;

    /**
     * Method uploads offers to database.
     * @param uploadOffersCommand - command with source of offers.
     */
    public void uploadOffers(UploadOffersCommand uploadOffersCommand){
        if(uploadOffersCommand.offerSource().equals(OfferSource.JUST_JOIN)){

            offerFactory = new JustJoinOfferUploaderFactory(offerService, justJoinClient, new JustJoinToOfferConverter(), new JustJoinOffersWrapper(List.of()));
            offerFactory.uploadOffer();
        }
        else if(uploadOffersCommand.offerSource().equals(OfferSource.JANUSZ_SOFT)){
            offerFactory = new JanuszSoftOfferUploaderFactory(offerService, januszSoftClient, new JanuszSoftOfferConverter(), new JanuszSoftOffersWrapper(List.of()));
            offerFactory.uploadOffer();
        }
        else {
            throw new IllegalArgumentException("Invalid source");
        }
        // cases for next sources will be implemented as soon as sources are reachable.
    }
}
