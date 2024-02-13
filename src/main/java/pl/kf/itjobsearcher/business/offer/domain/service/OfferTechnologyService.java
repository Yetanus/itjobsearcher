package pl.kf.itjobsearcher.business.offer.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.kf.itjobsearcher.business.offer.domain.TechnologyErrorCode;
import pl.kf.itjobsearcher.business.offer.domain.mapper.TechnologyMapper;
import pl.kf.itjobsearcher.business.offer.domain.repository.OfferTechnologyRepository;
import pl.kf.itjobsearcher.business.offer.dto.TechnologyQuery;
import pl.kf.itjobsearcher.common.exception.ITJobSearcherBusinessException;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class OfferTechnologyService {
    private final OfferTechnologyRepository offerTechnologyRepository;

    public TechnologyQuery findTechnologyById(Long id) {
        return offerTechnologyRepository.findById(id)
                .map(TechnologyMapper::mapToTechnologyQuery)
                .orElseThrow(() -> new ITJobSearcherBusinessException(TechnologyErrorCode.TECHNOLOGY_NOT_FOUND, "Technology does not exist"));
    }

    public List<TechnologyQuery> findAllTechnologies() {
        return offerTechnologyRepository.findAll()
                .stream()
                .map(TechnologyMapper::mapToTechnologyQuery)
                .filter(Objects::nonNull)
                .toList();
    }


}
