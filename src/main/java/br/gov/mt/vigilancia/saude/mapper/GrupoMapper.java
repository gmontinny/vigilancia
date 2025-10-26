package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Grupo;
import br.gov.mt.vigilancia.saude.dto.GrupoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SubgrupoMapper.class})
public interface GrupoMapper {

    GrupoMapper INSTANCE = Mappers.getMapper(GrupoMapper.class);

    @Mapping(source = "subgrupos", target = "subgrupos")
    GrupoDTO toDto(Grupo grupo);

    @Mapping(target = "subgrupos", ignore = true)
    Grupo toEntity(GrupoDTO grupoDTO);
}
