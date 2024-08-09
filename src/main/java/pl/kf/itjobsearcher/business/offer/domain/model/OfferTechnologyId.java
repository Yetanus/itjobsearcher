package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class OfferTechnologyId implements Serializable {

    @NotNull
    @Column(name = "offer_uuid")
    private UUID offerUuid;

    @NotNull
    @Column(name = "technology_uuid")
    private UUID technologyUuid;

}
