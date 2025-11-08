package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Gestaodocumento;
import br.gov.mt.vigilancia.saude.dto.GestaodocumentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GestaodocumentoMapper {

    GestaodocumentoMapper INSTANCE = Mappers.getMapper(GestaodocumentoMapper.class);

    GestaodocumentoDTO toDTO(Gestaodocumento gestaodocumento);
    Gestaodocumento toEntity(GestaodocumentoDTO gestaodocumentoDTO);
}
