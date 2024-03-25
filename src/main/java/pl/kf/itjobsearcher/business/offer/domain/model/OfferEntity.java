package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kf.itjobsearcher.business.offer.domain.OfferConstant;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
@Table(name = "t_offer")
public class OfferEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @ElementCollection(targetClass = ContractType.class)
    @JoinTable(name = "t_offer", joinColumns = @JoinColumn(name = "uuid"))
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    private List<ContractType> contractType;

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

    @Column(name = "required_skills")
    private String requiredSkills;

    @NotBlank
    @Size(max = OfferConstant.MAX_TITLE_LENGTH)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "description")
    private String description;
}
