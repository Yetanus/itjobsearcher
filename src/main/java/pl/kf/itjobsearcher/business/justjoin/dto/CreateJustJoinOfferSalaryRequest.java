package pl.kf.itjobsearcher.business.justjoin.dto;

import pl.kf.itjobsearcher.business.justjoin.CreateJustJoinOfferSalaryCommand;
import pl.kf.itjobsearcher.business.justjoin.offer.domain.model.JustJoinOfferSalaryEntity;
import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;
import pl.kf.itjobsearcher.business.offer.dto.CreateTechnologyCommand;

public record CreateJustJoinOfferSalaryRequest(
        JustJoinOfferSalaryEntity justJoinOfferSalaryEntity
) {
    public CreateJustJoinOfferSalaryCommand createJustJoinOfferSalaryCommand(){
        return CreateJustJoinOfferSalaryCommand.builder()
                .justJoinOfferSalaryEntity()
    }
}
