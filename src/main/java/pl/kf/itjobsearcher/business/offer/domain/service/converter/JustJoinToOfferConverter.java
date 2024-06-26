package pl.kf.itjobsearcher.business.offer.domain.service.converter;

import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinOffer;
import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinOffersWrapper;
import pl.kf.itjobsearcher.business.offer.domain.model.ContractType;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;

import java.math.BigInteger;
import java.util.List;

public class JustJoinToOfferConverter implements OfferConverter<JustJoinOffersWrapper> {
    @Override
    public List<CreateOfferCommand> convert(JustJoinOffersWrapper justJoinOffersWrapper) {
        return justJoinOffersWrapper.offers()
                .stream()
                .map(this::buildCreateOfferCommand)
                .toList();
    }

    private BigInteger convertMinSalary() {
        BigInteger convertedSalary = BigInteger.ONE;
        return convertedSalary;
    }

    private BigInteger convertMaxSalary() {

        return null;
    }

    private CreateOfferCommand buildCreateOfferCommand(JustJoinOffer justJoinOffer) {
        List contractTypes;
        if (justJoinOffer.employmentType().equals(ContractType.UOP)) {
            contractTypes = List.of(ContractType.UOP);
        } else if (justJoinOffer.employmentType().equals(ContractType.B2B)) {
            contractTypes = List.of(ContractType.B2B);
        } else {
            throw new RuntimeException("Unsupported deal type");
        }
        return CreateOfferCommand.builder()
                .title(justJoinOffer.title())
                .description(justJoinOffer.slug())
                .minSalary(convertMinSalary())
                .maxSalary(convertMaxSalary())
                .contractTypes(contractTypes)
                .build();
    }
}
