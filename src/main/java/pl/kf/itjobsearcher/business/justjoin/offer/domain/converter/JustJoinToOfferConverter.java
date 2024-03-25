package pl.kf.itjobsearcher.business.justjoin.offer.domain.converter;


import pl.kf.itjobsearcher.business.justjoin.offer.domain.model.JustJoinOfferEntity;
import pl.kf.itjobsearcher.business.offer.converter.OfferConverter;
import pl.kf.itjobsearcher.business.offer.domain.model.OfferEntity;
import pl.kf.itjobsearcher.business.offer.domain.model.ProgrammingSkill;


import java.util.List;
import java.util.UUID;
public class JustJoinToOfferConverter implements OfferConverter<JustJoinOfferEntity, OfferEntity> {

    @Override
    public OfferEntity convert(JustJoinOfferEntity source) {
        UUID uuid = new OfferEntity().getUuid();
        String title = source.getTitle();
        List<ProgrammingSkill> requiredSkill = convertRequiredSkill(source);
        String description = source.getOfferBody();
        return OfferEntity.builder()
                .uuid(uuid)
                .title(title)
                .requiredSkill(requiredSkill)
                .description(description)
                .build();
    }

    public List<ProgrammingSkill> convertRequiredSkill(JustJoinOfferEntity source) {
        //todo Pytanie: pętla i potem do listy wszystkie? da sie szybciej?
        return null;
    }


}
