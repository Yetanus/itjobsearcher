package pl.kf.itjobsearcher.business.offer.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table("t_tech")
public class RequiredTechs {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID, generator = "sg_offer")
    @Column(name = "id")
    private Long id;

    @ManyToMany
    Set<OfferEntity> offers;
}
