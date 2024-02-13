package pl.kf.itjobsearcher.business.offer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferTechnologyEntity;

public interface OfferTechnologyRepository extends JpaRepository<OfferTechnologyEntity, Long> {
}
