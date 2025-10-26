package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Documento;
import br.gov.mt.vigilancia.saude.dto.DocumentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

    DocumentoMapper INSTANCE = Mappers.getMapper(DocumentoMapper.class);

    DocumentoDTO toDto(Documento documento);

    Documento toEntity(DocumentoDTO documentoDTO);
}
