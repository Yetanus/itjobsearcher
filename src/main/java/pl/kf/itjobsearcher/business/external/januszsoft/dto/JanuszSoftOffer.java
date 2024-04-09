package pl.kf.itjobsearcher.business.external.januszsoft.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record JanuszSoftOffer(
        String title,
        String description,
        String contractType,
        BigDecimal minSalary,
        BigDecimal maxSalary
) { }
