package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg_offer")
    @SequenceGenerator(name = "sg_offer", sequenceName = "sq_offer", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "contract")
    private ContractType typeContract;

    @Min(0)
    @Max(100000)
    @Column(name = "money")
    private BigDecimal money;
    //Todo min max, numeric lepiej, wartosc numeryczna, experienceInYears lepiej
    @Column(name = "exp")
    private String exp;
    //Todo zrobic nowa tabele z tego, relacja 1doWielu, osobna encja, wyswietlanie danych w jeden konkretny sposob, algorytmy eliminujace duplikaty
    @Column(name = "requiredtechs")
    private String techs;
    //Todo zmienna text w postgresie, wywalic size, nie ograniczac
    @NotNull
    @Size(max = 255)
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
