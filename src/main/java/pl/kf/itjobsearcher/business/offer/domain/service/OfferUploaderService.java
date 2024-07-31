package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftOffersWrapper;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinClient;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinOffersWrapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.OfferConverter;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.UploadOffersCommand;

import java.util.List;

@RequiredArgsConstructor
public class OfferUploaderService {

    private final OfferService offerService;
    //TODO z klientami podobnie zrobic jak z konwerterem, ale bedzie to wymagac stworzenia interfejsu
    // dla wszystkich klientow
    private final JustJoinClient justJoinClient;
    private final OfferConverter<JanuszSoftOffersWrapper> januszSoftOfferConverter;
    private final OfferConverter<JustJoinOffersWrapper> justJoinOffersOfferConverter;

    private void uploadOffersFromJanuszSoft(JanuszSoftOffersWrapper januszSoftOffersWrapper) {
        List<CreateOfferCommand> createOfferCommand = offerConverters.get(OfferSource.JANUSZ_SOFT).convert(januszSoftOffersWrapper);
        offerService.createOffers(createOfferCommand, OfferSource.JANUSZ_SOFT);
    }

    private void uploadOffersFromJustJoin(JustJoinOffersWrapper justJoinOffersWrapper){
        List<CreateOfferCommand> createOfferCommands = offerConverters.get(OfferSource.JUST_JOIN).convert(justJoinOffersWrapper);
        offerService.createOffers(createOfferCommands, OfferSource.JUST_JOIN);
    }

    public void uploadOffers(UploadOffersCommand uploadOffersCommand){
        if(uploadOffersCommand.offerSource().equals(OfferSource.JUST_JOIN)){
            JustJoinOffersWrapper offersWrapper = justJoinClient.fetchOffers();
            uploadOffersFromJustJoin(offersWrapper);
        }
        else {
            throw new IllegalArgumentException("Invalid source");
        }
        // cases for next sources will be implemented as soon as sources are reachable.
    }
}
