package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

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
    @Column(name = "required_skills")
    private String requiredSkills;

    @NotBlank
    @Size(max = OfferConstant.MAX_TITLE_LENGTH)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "description")
    private String description;

    @NotBlank
    @Column(name = "data_source")
    private String dataSource;
}
