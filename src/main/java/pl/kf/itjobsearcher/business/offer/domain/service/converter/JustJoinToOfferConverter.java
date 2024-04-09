package pl.kf.itjobsearcher.business.offer.domain.service.converter;

import pl.kf.itjobsearcher.business.external.justjoin.offer.dto.JustJoinOffer;
import pl.kf.itjobsearcher.business.external.justjoin.offer.dto.JustJoinOffersWrapper;
import pl.kf.itjobsearcher.business.offer.domain.model.ContractType;
import pl.kf.itjobsearcher.business.offer.domain.model.ProgrammingSkill;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
public class JustJoinToOfferConverter implements OfferConverter<JustJoinOffersWrapper> {
    @Override
    public List<CreateOfferCommand> convert(JustJoinOffersWrapper justJoinOffersWrapper) {
        return justJoinOffersWrapper.offers()
                .stream()
                .map(this::buildCreateOfferCommand)
                .toList();
    }
    private BigDecimal convertMinSalary(){

    }

    private BigDecimal convertMaxSalary(){

    }
}


    private CreateOfferCommand buildCreateOfferCommand(JustJoinOffer justJoinOffer){
        List<ContractType> contractTypes = switch (justJoinOffer.employmentType()){
            case "permanent" -> List.of(ContractType.UOP);
            case "b2b" -> List.of(ContractType.B2B);
        };
   return CreateOfferCommand.builder()
           .title(justJoinOffer.title())
           .description(justJoinOffer.slug())
           .



}
