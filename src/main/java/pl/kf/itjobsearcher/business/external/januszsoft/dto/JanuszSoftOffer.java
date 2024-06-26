package pl.kf.itjobsearcher.business.external.januszsoft.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Offer Class for Janusz Soft.
 */
@Builder
public record JanuszSoftOffer(
        String title,
        String description,
        String contractType,
        BigInteger minSalary,
        BigInteger maxSalary
) { }
