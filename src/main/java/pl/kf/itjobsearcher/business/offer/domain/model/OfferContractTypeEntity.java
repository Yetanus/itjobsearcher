package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_offer_contract_type")
public class OfferContractTypeEntity {

    @EmbeddedId
    private OfferContractTypeId offerContractTypeId;

    @PositiveOrZero
    @Column(name = "salary_min")
    private BigInteger salaryMin;

    @PositiveOrZero
    @Column(name = "salary_max")
    private BigInteger salaryMax;
}
