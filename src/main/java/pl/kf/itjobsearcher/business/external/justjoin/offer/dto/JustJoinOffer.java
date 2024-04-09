package pl.kf.itjobsearcher.business.external.justjoin.offer.dto;

import lombok.Builder;

@Builder
public record JustJoinOffer(
        String slug,
        String title,
        String[] requiredSkills,
        String[] niceToHaveSkills,
        String workplaceType,
        String experienceLevel,
        String[] employmentType,
        String companyName,
        String companyCity
) {}
