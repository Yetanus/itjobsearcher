package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import pl.kf.itjobsearcher.business.offer.domain.OfferConstant;

import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_offer")
public class OfferEntity {
//2. TODO zgodnie z modelem napisać cały kod od modelu przez konwerter do źródła danych i dac PRa

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID, generator = "sg_offer")
    @Column(name = "uuid")
    private UUID uuid;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "contract")
    private ContractType typeContract;
    // todo w przyszlosci cache jako hashmapa do pobierania waluty i konwersji tych ofert co nie sa w PLN
    @PositiveOrZero
    @Column(name = "money", precision = 10, scale = 2)
    private BigInteger money;
    @Min(0)
    @Max(30)
    @Column(name = "exp")
    private Integer experienceInYears;

    @ManyToMany
    private Set<OfferTechnologyEntity> techs;

    @Column(name = "description")
    private String description;

    @NotNull
    @Size(max = 255)
    @Column(name = "offertitle")
    private String offerTitle;

    @NotNull
    @Size(max = 255)
    @Column(name = "role")
    private String role;
}
