package pl.kf.itjobsearcher.business.justjoin.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kf.itjobsearcher.business.offer.domain.OfferConstant;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
@Table(name = "t_jj_offer")
public class JustJoinOfferEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @NotBlank
    @Size(max = OfferConstant.MAX_TITLE_LENGTH)
    @Column(name = "title")
    private String title;

    @Column(name = "required_skills")
    private String requiredSkills;

    @Column(name = "nice_to_have_skills")
    private String niceToHaveSkills;

    @Column(name = "workplace_type")
    private String workplaceType;

    @Column(name = "working_time")
    private String workingTimeType;

    @Column(name = "experience_level")
    private String expLevel;

    @Column(name = "multilocation")
    private String workingLocation;

    @NotBlank
    @Size(max = OfferConstant.MAX_TITLE_LENGTH)
    @Column(name = "company_city")
    private String companyCity;

    @NotBlank
    @Size(max = OfferConstant.MAX_TITLE_LENGTH)
    @Column(name = "company_street")
    private String companyStreet;

    @NotBlank
    @Size(max = OfferConstant.MAX_TITLE_LENGTH)
    @Column(name = "company_name")
    private String companyName;

    @NotBlank
    @Temporal(TemporalType.DATE)
    @Column(name = "published_at")
    private Date publishedDate;

    @NotBlank
    @Column(name = "offer_body")
    private String offerBody;
}
