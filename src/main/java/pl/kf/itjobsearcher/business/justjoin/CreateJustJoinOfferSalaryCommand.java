package pl.kf.itjobsearcher.business.justjoin;

import lombok.Builder;
import pl.kf.itjobsearcher.business.justjoin.offer.domain.model.JustJoinOfferSalaryEntity;

@Builder
public record CreateJustJoinOfferSalaryCommand(
        JustJoinOfferSalaryEntity justJoinOfferSalaryEntity
) {
}
