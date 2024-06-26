package pl.kf.itjobsearcher.business.external.justjoin.dto;

import lombok.Builder;

/**
 * DTO class, with all fields required for every offer from JustJoinIT
 */
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
