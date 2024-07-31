package pl.kf.itjobsearcher.business.offer.domain.model;

import java.util.List;

public interface OfferWrapper<T> {
    List<T> offers();
}
