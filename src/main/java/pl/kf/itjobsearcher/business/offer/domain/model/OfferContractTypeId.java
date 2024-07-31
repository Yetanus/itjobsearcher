package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class OfferContractTypeId implements Serializable {

    @NotNull
    @Column(name = "offer_uuid")
    private UUID offerUuid;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    private ContractType contractType;
}
