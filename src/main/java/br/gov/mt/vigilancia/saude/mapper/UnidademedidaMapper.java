package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Unidademedida;
import br.gov.mt.vigilancia.saude.dto.UnidademedidaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UnidademedidaMapper {

    UnidademedidaMapper INSTANCE = Mappers.getMapper(UnidademedidaMapper.class);

    UnidademedidaDTO toDto(Unidademedida unidademedida);

    Unidademedida toEntity(UnidademedidaDTO unidademedidaDTO);
}
