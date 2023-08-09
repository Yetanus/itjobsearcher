package pl.kf.itjobsearcher.business.offer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

}
