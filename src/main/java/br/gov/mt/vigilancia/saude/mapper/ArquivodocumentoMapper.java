package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Arquivodocumento;
import br.gov.mt.vigilancia.saude.dto.ArquivodocumentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArquivodocumentoMapper {

    ArquivodocumentoMapper INSTANCE = Mappers.getMapper(ArquivodocumentoMapper.class);

    ArquivodocumentoDTO toDTO(Arquivodocumento arquivodocumento);
    Arquivodocumento toEntity(ArquivodocumentoDTO arquivodocumentoDTO);
}
