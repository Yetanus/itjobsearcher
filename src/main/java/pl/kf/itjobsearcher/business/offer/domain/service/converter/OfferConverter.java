package pl.kf.itjobsearcher.business.offer.domain.service.converter;

import pl.kf.itjobsearcher.business.external.justjoin.dto.JustJoinOffersWrapper;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;

import java.util.List;

public interface OfferConverter<T> {
    List<CreateOfferCommand> convert(T source);
}
