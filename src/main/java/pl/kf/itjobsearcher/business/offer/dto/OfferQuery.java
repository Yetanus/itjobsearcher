package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;
import pl.kf.itjobsearcher.business.offer.domain.model.ContractType;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Builder
public record OfferQuery(
        UUID uuid,
        List<ContractType> contractType,
        BigInteger salaryMin,
        BigInteger salaryMax,
        Long requiredExperienceInYears,
        String requiredSkills,
        String title,
        String description
) { }
