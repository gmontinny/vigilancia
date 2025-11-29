package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Timelineadm;
import br.gov.mt.vigilancia.saude.dto.TimelineadmDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TimelineadmMapper {

    TimelineadmMapper INSTANCE = Mappers.getMapper(TimelineadmMapper.class);

    TimelineadmDTO toDTO(Timelineadm timelineadm);
    Timelineadm toEntity(TimelineadmDTO timelineadmDTO);
}
