package pl.kf.itjobsearcher.business.offer.domain.service.converter;

import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftOffer;
import pl.kf.itjobsearcher.business.external.januszsoft.dto.JanuszSoftOffersWrapper;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinOffersWrapper;
import pl.kf.itjobsearcher.business.offer.domain.model.ContractType;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;

import java.util.List;

public class JanuszSoftOfferConverter implements OfferConverter<JanuszSoftOffersWrapper> {

    @Override
    public List<CreateOfferCommand> convert(JustJoinOffersWrapper januszSoftOffersWrapper) {
        return januszSoftOffersWrapper.offers()
                .stream()
                .map(this::buildCreateOfferCommand)
                .toList();
    }

    private CreateOfferCommand buildCreateOfferCommand(JanuszSoftOffer januszSoftOffer) {
        List<ContractType> contractTypes = switch (januszSoftOffer.contractType()) {
            case "B2B" -> List.of(ContractType.B2B);
            default -> List.of(ContractType.UOP);
        };
        return CreateOfferCommand.builder()
                .title(januszSoftOffer.title())
                .description(januszSoftOffer.description())
                .minSalary(januszSoftOffer.minSalary())
                .maxSalary(januszSoftOffer.maxSalary())
                .contractTypes(contractTypes)
                .build();
    }
}
