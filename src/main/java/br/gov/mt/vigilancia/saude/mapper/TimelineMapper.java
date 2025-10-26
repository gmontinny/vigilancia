package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Timeline;
import br.gov.mt.vigilancia.saude.dto.TimelineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface TimelineMapper {

    TimelineMapper INSTANCE = Mappers.getMapper(TimelineMapper.class);

    @Mapping(source = "usuario.id", target = "idUsuario")
    TimelineDTO toDto(Timeline timeline);

    @Mapping(target = "usuario", ignore = true)
    Timeline toEntity(TimelineDTO timelineDTO);
}
