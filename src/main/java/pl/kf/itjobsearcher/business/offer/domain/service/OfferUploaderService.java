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
    private final JustJoinClient justJoinClient;
    private final OfferConverter<JanuszSoftOffersWrapper> januszSoftOfferConverter;
    private final OfferConverter<JustJoinOffersWrapper> justJoinOffersOfferConverter;

    private void uploadOffersFromJanuszSoft(JanuszSoftOffersWrapper januszSoftOffersWrapper) {
        List<CreateOfferCommand> createOfferCommand = januszSoftOfferConverter.convert(januszSoftOffersWrapper);
        offerService.createOffers(createOfferCommand, OfferSource.JANUSZ_SOFT);
    }

    private void uploadOffersFromJustJoin(JustJoinOffersWrapper justJoinOffersWrapper){
        List<CreateOfferCommand> createOfferCommands = justJoinOffersOfferConverter.convert(justJoinOffersWrapper);
        offerService.createOffers(createOfferCommands, OfferSource.JUST_JOIN);
    }

    public void uploadOffers(UploadOffersCommand uploadOffersCommand){
        OfferSource offerSource = switch (uploadOffersCommand.offerSource()){
            case JUST_JOIN -> {
                JustJoinOffersWrapper offersWrapper = justJoinClient.fetchOffers();
                uploadOffersFromJustJoin(offersWrapper);
            }
            case LINKEDIN -> {
              // 2. Otrzymac dnae z Linkedin
            }
            case JANUSZ_SOFT -> {
            }
            case NO_FLUFF_JOBS -> {
                //todo will be implemented
            }
            default -> throw new IllegalArgumentException("Invalid source");
        };
    }
}
