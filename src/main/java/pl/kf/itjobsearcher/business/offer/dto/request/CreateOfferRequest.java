package pl.kf.itjobsearcher.business.offer.dto.request;

import pl.kf.itjobsearcher.business.offer.dto.CreateOfferCommand;

public record CreateOfferRequest(
        String description
) {

    public CreateOfferCommand toCreateOfferCommand() {
        return CreateOfferCommand.builder()
                .description(description)
                .build();
    }
}
