package pl.kf.itjobsearcher.business.justjoin.offer.domain.converter;

import pl.kf.itjobsearcher.business.justjoin.offer.domain.model.JustJoinOfferSalaryEntity;
import pl.kf.itjobsearcher.business.offer.converter.OfferConverter;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.UUID;

public class JustJoinSalaryToOfferConverter implements OfferConverter<JustJoinOfferSalaryEntity, OfferEntity> {

    @Override
    public OfferEntity convert(JustJoinOfferSalaryEntity source) {
        UUID uuid = new OfferEntity().getUuid();
        BigInteger salaryMin = checkMin(source);
        BigInteger salaryMax = checkMax(source);
        return OfferEntity.builder()
                .uuid(uuid)
                .salaryMin(salaryMin)
                .salaryMax(salaryMax)
                .build();
    }
    private BigInteger checkMin(JustJoinOfferSalaryEntity source){
        HashSet<BigInteger> minValues= new HashSet<>();
        minValues.add(source.getFromB2b());
        minValues.add(source.getFromUd());
        minValues.add(source.getFromUz());
        minValues.add(source.getFromPermanent());
        return minValues.stream().min(BigInteger::compareTo).get();
    }

    private BigInteger checkMax(JustJoinOfferSalaryEntity source){
        HashSet<BigInteger> maxValues= new HashSet<>();
        maxValues.add(source.getToB2b());
        maxValues.add(source.getToUd());
        maxValues.add(source.getToUz());
        maxValues.add(source.getToPermanent());
        return maxValues.stream().min(BigInteger::compareTo).get();
    }

}
