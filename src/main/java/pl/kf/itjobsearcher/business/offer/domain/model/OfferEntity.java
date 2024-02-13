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
    // 1. dopisac encje dla offerToTechnology
//2. TODO zgodnie z modelem napisać cały kod od modelu przez konwerter do źródła danych i dac PRa

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID, generator = "sg_offer")
    @Column(name = "uuid")
    private UUID uuid;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    private ContractType contractType;

    @PositiveOrZero
    @Column(name = "salary_min")
    private BigInteger salaryMin;

    @PositiveOrZero
    @Column(name = "salary_max")
    private BigInteger salaryMax;

    @Min(OfferConstant.MIN_REQUIRED_EXPERIENCE_IN_YEARS)
    @Max(OfferConstant.MAX_REQUIRED_EXPERIENCE_IN_YEARS)
    @Column(name = "required_experience_in_years")
    private Long requiredExperienceInYears;

    @NotBlank
    @Size(max = OfferConstant.MAX_TITLE_LENGTH)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "description")
    private String description;
}
