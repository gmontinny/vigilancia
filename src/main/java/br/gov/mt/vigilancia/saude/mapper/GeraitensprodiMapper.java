package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geraitensprodi;
import br.gov.mt.vigilancia.saude.dto.GeraitensprodiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeraitensprodiMapper {

    GeraitensprodiMapper INSTANCE = Mappers.getMapper(GeraitensprodiMapper.class);

    GeraitensprodiDTO toDTO(Geraitensprodi geraitensprodi);
    Geraitensprodi toEntity(GeraitensprodiDTO geraitensprodiDTO);
}
