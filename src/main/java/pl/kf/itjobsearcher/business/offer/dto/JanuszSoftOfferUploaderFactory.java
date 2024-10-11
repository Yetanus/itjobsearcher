package pl.kf.itjobsearcher.business.offer.dto;

import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftClient;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftOffersWrapper;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferSource;
import pl.kf.itjobsearcher.business.offer.domain.service.OfferService;
import pl.kf.itjobsearcher.business.offer.domain.service.converter.OfferConverter;

import java.util.List;

public class JanuszSoftOfferUploaderFactory implements OfferFactory {
    private final OfferService offerService;
    private final JanuszSoftClient januszSoftClient;
    private final OfferConverter<JanuszSoftOffersWrapper> januszSoftOfferConverter;
    private final JanuszSoftOffersWrapper januszSoftOffersWrapper;

    public JanuszSoftOfferUploaderFactory(OfferService offerService, JanuszSoftClient januszSoftClient, OfferConverter<JanuszSoftOffersWrapper> januszSoftOfferConverter, JanuszSoftOffersWrapper januszSoftOffersWrapper) {
        this.offerService = offerService;
        this.januszSoftClient = januszSoftClient;
        this.januszSoftOfferConverter = januszSoftOfferConverter;
        this.januszSoftOffersWrapper = januszSoftOffersWrapper;
    }

    @Override
    public void uploadOffer() {
        List<CreateOfferCommand> createOfferCommand = januszSoftOfferConverter.convert(januszSoftOffersWrapper);
        offerService.createOffers(createOfferCommand, OfferSource.JANUSZ_SOFT);
        januszSoftClient.fetchOffers();
    }
}
