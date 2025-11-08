package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geratermorevelia;
import br.gov.mt.vigilancia.saude.dto.GeratermoreveliaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeratermoreveliaMapper {

    GeratermoreveliaMapper INSTANCE = Mappers.getMapper(GeratermoreveliaMapper.class);

    GeratermoreveliaDTO toDTO(Geratermorevelia geratermorevelia);
    Geratermorevelia toEntity(GeratermoreveliaDTO geratermoreveliaDTO);
}
