package pl.kf.itjobsearcher.business.offer.dto;

import lombok.Builder;
import pl.kf.itjobsearcher.business.offer.domain.model.ContractType;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record CreateOfferCommand(
        String title,
        String description,
        List<ContractType> contractTypes,
        BigDecimal minSalary,
        BigDecimal maxSalary
) { }
