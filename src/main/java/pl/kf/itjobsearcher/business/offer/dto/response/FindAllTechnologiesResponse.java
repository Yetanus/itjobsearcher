package pl.kf.itjobsearcher.business.offer.dto.response;

import pl.kf.itjobsearcher.business.offer.dto.TechnologyQuery;

import java.util.List;

public record FindAllTechnologiesResponse(
        long numberOfTechnologies,
        List<TechnologyResponse> technologies
) {
    public static FindAllTechnologiesResponse fromQueries(List<TechnologyQuery> technologyQueries){
        List<TechnologyResponse> technologyResponses = technologyQueries.stream()
                .map(TechnologyResponse::fromQuery)
                .toList();

        return new FindAllTechnologiesResponse(
                technologyResponses.size(),
                technologyResponses
        );
    }
}
