package pl.kf.itjobsearcher.business.justjoin.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
@Table(name = "t_jj_offer_salary_range")
public class JustJoinOfferSalaryEntity {
//TODO konwerter i dto external, nic wiecej
    @NotNull
    @EmbeddedId
    @Column(name = "offer_uuid", updatable = false)
    private UUID uuid;

    @Column(name = "to_b2b")
    private BigInteger toB2b;

    @Column(name = "from_b2b")
    private BigInteger fromB2b;

    @Column(name = "to_permanent")
    private BigInteger toPermanent;

    @Column(name = "from_permanent")
    private BigInteger fromPermanent;

    @Column(name = "to_uz")
    private BigInteger toUz;

    @Column(name = "from_uz")
    private BigInteger fromUz;

    @Column(name = "to_ud")
    private BigInteger toUd;

    @Column(name = "from_ud")
    private BigInteger fromUd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_uuid", updatable = false, insertable = false)
    private JustJoinOfferEntity justJoinOfferEntity;
}
