package pl.kf.itjobsearcher.business.justjoin.offer.dto;

import pl.kf.itjobsearcher.business.justjoin.CreateJustJoinOfferSalaryCommand;
import pl.kf.itjobsearcher.business.justjoin.offer.domain.model.JustJoinOfferSalaryEntity;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.CreateTechnologyCommand;

import java.math.BigInteger;
import java.util.UUID;

public record CreateJustJoinOfferSalaryRequest(
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
    public CreateJustJoinOfferSalaryCommand createJustJoinOfferSalaryCommand(){
        return CreateJustJoinOfferSalaryCommand.builder()
                .uuid(uuid)
                .toB2b(toB2b)
                .fromB2b(fromB2b)
                .toPermanent(toPermanent)
                .fromPermanent(fromPermanent)
                .toUz(toUz)
                .fromUz(fromUz)
                .toUd(toUd)
                .fromUd(fromUd)
                .build();
    }
}
