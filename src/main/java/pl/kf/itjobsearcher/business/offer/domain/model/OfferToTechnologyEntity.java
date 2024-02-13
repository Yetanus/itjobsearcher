package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_offer_to_technology")
public class OfferToTechnologyEntity {
//todo klucz kompozytowy zlozony tutaj brakuje EmbeddedId
    @Id
    @NotNull
    @Column(name = "offer_uuid", updatable = false)
    private UUID offerUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_uuid", updatable = false, insertable = false)
    private OfferEntity offerEntity;

    @Id
    @NotNull
    @Column(name = "technology_uuid", updatable = false)
    private UUID technologyUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technology_uuid", updatable = false, insertable = false)
    private OfferTechnologyEntity offerTechnologyEntity;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "technology_level")
    private OfferTechnologyLevel technologyLevel;
}
