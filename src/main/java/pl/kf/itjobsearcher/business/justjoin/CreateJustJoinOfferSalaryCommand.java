package pl.kf.itjobsearcher.business.justjoin;

import lombok.Builder;
import pl.kf.itjobsearcher.business.justjoin.offer.domain.model.JustJoinOfferSalaryEntity;

import java.math.BigInteger;
import java.util.UUID;

@Builder
public record CreateJustJoinOfferSalaryCommand(
        UUID uuid,
        BigInteger toB2b,
        BigInteger fromB2b,
        BigInteger toPermanent,
        BigInteger fromPermanent,
        BigInteger toUz,
        BigInteger fromUz,
        BigInteger toUd,
        BigInteger fromUd
) {
}
