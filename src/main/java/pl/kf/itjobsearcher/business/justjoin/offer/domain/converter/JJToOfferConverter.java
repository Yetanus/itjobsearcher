package pl.kf.itjobsearcher.business.justjoin.offer.domain.converter;


import org.springframework.core.convert.converter.Converter;
import pl.kf.itjobsearcher.business.justjoin.offer.domain.model.JJOfferEntity;
import pl.kf.itjobsearcher.business.offer.domain.model.ContractType;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;

import java.math.BigInteger;
import java.util.UUID;

public class JJToOfferConverter implements Converter<JJOfferEntity, OfferEntity> {

    @Override
    public OfferEntity convert(JJOfferEntity source) {
        UUID uuid = new OfferEntity().getUuid();
        ContractType contractType = null;
        BigInteger salaryMin = null;
        BigInteger salaryMax = null;
        Long requiredExpInYears = 0l;
        String title = source.getTitle();
        String description = source.getOfferBody();
        return new OfferEntity(
                uuid,
                contractType,
                salaryMin,
                salaryMax,
                requiredExpInYears,
                title,
                description
        );
    }

    @Override
    public <U> Converter<JJOfferEntity, U> andThen(Converter<? super OfferEntity, ? extends U> after) {
        return Converter.super.andThen(after);
    }

}
