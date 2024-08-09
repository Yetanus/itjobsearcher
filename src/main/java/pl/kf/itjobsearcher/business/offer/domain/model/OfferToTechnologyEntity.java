package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_offer_to_technology")
public class OfferToTechnologyEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "technology_level")
    private OfferTechnologyLevel offerTechnologyLevel;

    @EmbeddedId
    private OfferTechnologyId offerTechnologyId;
}

