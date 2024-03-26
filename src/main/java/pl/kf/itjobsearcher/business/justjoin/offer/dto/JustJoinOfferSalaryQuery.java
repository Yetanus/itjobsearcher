package pl.kf.itjobsearcher.business.justjoin.offer.dto;

import java.math.BigInteger;
import java.util.UUID;

public record JustJoinOfferSalaryQuery(
        UUID uuid,
        BigInteger toB2b,
        BigInteger fromB2b,
        BigInteger toPermanent,
        BigInteger fromPermanent,
        BigInteger toUz,
        BigInteger fromUz,
        BigInteger toUd,
        BigInteger fromUd

        //todo Pytanie: czy tutaj ma byc to polaczenie z odpowiadajacym mu DTO z jjEntity?
) {
}
