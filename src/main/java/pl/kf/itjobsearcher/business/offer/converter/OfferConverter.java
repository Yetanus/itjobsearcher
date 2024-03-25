package pl.kf.itjobsearcher.business.offer.converter;

public interface OfferConverter<T, U> {
    U convert(T source);
}
