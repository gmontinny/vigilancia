package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geradocumento;
import br.gov.mt.vigilancia.saude.dto.GeradocumentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeradocumentoMapper {

    GeradocumentoMapper INSTANCE = Mappers.getMapper(GeradocumentoMapper.class);

    GeradocumentoDTO toDTO(Geradocumento geradocumento);
    Geradocumento toEntity(GeradocumentoDTO geradocumentoDTO);
}
