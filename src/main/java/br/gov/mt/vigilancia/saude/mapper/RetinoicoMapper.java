package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Retinoico;
import br.gov.mt.vigilancia.saude.dto.RetinoicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RetinoicoMapper {

    RetinoicoMapper INSTANCE = Mappers.getMapper(RetinoicoMapper.class);

    RetinoicoDTO toDTO(Retinoico retinoico);
    Retinoico toEntity(RetinoicoDTO retinoicoDTO);
}
