package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.RequiredArgsConstructor;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftOffersWrapper;
import pl.kf.itjobsearcher.business.external.justjoin.offer.dto.JustJoinOffersWrapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.OfferConverter;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;

import java.util.List;

@RequiredArgsConstructor
public class OfferUploaderService {

    private final OfferService offerService;
    private final OfferConverter<JanuszSoftOffersWrapper> januszSoftOfferConverter;
    private final OfferConverter<JustJoinOffersWrapper> justJoinOffersOfferConverter;

    void uploadOffersFromJanuszSoft(JanuszSoftOffersWrapper januszSoftOffersWrapper) {
        List<CreateOfferCommand> createOfferCommand = januszSoftOfferConverter.convert(januszSoftOffersWrapper);
        offerService.createOffer(createOfferCommand, OfferSource.JANUSZ_SOFT);
    }

    void uploadOffersFromJustJoin(JustJoinOffersWrapper justJoinOffersWrapper){
        List<CreateOfferCommand> createOfferCommands = justJoinOffersOfferConverter.convert(justJoinOffersWrapper);
        offerService.createOffer(createOfferCommands,OfferSource.JUST_JOIN);
    }

    // 1000
}
