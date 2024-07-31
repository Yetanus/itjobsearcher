package pl.kf.itjobsearcher.business.offer.domain.mapper;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

import java.util.Objects;

public record OfferMapper() {

    public static OfferQuery mapToOfferQuery(OfferEntity offerEntity) {
        if (offerEntity == null) {
            return null;
        }
        return OfferQuery.builder()
                .uuid(offerEntity.getUuid())
                //.contractType(offerEntity.getContractType())
                .salaryMin(offerEntity.getSalaryMin())
                .salaryMax(offerEntity.getSalaryMax())
                .requiredExperienceInYears(offerEntity.getRequiredExperienceInYears())
                .requiredSkills(offerEntity.getRequiredSkills())
                .title(offerEntity.getTitle())
                .description(offerEntity.getDescription())
                .build();
    }

    public static OfferEntity mapToOfferEntity(CreateOfferCommand createOfferCommand){
        Objects.requireNonNull(createOfferCommand);
        return OfferEntity.builder()
               // .contractType(createOfferCommand.contractTypes())
                .salaryMin(createOfferCommand.minSalary())
                .salaryMax(createOfferCommand.maxSalary())
                .title(createOfferCommand.title())
                .description(createOfferCommand.description())
                .build();

    }
}
