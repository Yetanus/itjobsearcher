package pl.kf.itjobsearcher.business.offer.dto.response;

import pl.kf.itjobsearcher.business.offer.dto.TechnologyQuery;

public record TechnologyResponse(
        Long id,
        String technology
) {
    public static TechnologyResponse fromQuery(TechnologyQuery technologyQuery){
        return new TechnologyResponse(
                technologyQuery.id(),
                technologyQuery.description()
        );
    }
}
