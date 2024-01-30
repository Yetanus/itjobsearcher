package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_offer")
public class OfferEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID, generator = "sg_offer")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "contract")
    private ContractType typeContract;
    // todo w przyszlosci cache jako hashmapa do pobierania waluty i konwersji tych ofert co nie sa w PLN
    @PositiveOrZero
    @Column(name = "money", precision = 10, scale = 2)
    private BigInteger money;
    @Min(0)
    @Max(20)
    @Column(name = "exp")
    private Integer experienceInYears;

    //todo manyToMany tablica
    @Column(name = "requiredtechs")
    private String techs;

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
