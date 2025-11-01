package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Documentoerrado;
import br.gov.mt.vigilancia.saude.dto.DocumentoerradoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentoerradoMapper {

    DocumentoerradoMapper INSTANCE = Mappers.getMapper(DocumentoerradoMapper.class);

    @Mapping(source = "uploadnecessario.iduploadnecessario", target = "iduploadnecessario")
    DocumentoerradoDTO toDTO(Documentoerrado documentoerrado);

    @Mapping(source = "iduploadnecessario", target = "uploadnecessario.iduploadnecessario")
    Documentoerrado toEntity(DocumentoerradoDTO documentoerradoDTO);
}
