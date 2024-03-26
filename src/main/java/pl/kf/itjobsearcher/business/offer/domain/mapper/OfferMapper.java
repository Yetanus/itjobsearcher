package pl.kf.itjobsearcher.business.offer.domain.mapper;

import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.dto.OfferQuery;

public record OfferMapper() {

    public static OfferQuery mapToOfferQuery(OfferEntity offerEntity) {
        if (offerEntity == null) {
            return null;
        }
        return OfferQuery.builder()
                .uuid(offerEntity.getUuid())
                .contractType(offerEntity.getContractType())
                .salaryMin(offerEntity.getSalaryMin())
                .salaryMax(offerEntity.getSalaryMax())
                .requiredExperienceInYears(offerEntity.getRequiredExperienceInYears())
                .requiredSkills(offerEntity.getRequiredSkills())
                .title(offerEntity.getTitle())
                .description(offerEntity.getDescription())
                .build();
    }
}
