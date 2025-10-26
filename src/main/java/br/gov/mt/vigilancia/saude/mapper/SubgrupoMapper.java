package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Subgrupo;
import br.gov.mt.vigilancia.saude.dto.SubgrupoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {GrupoMapper.class})
public interface SubgrupoMapper {

    SubgrupoMapper INSTANCE = Mappers.getMapper(SubgrupoMapper.class);

    @Mapping(source = "grupo.id", target = "idGrupo")
    SubgrupoDTO toDto(Subgrupo subgrupo);

    @Mapping(target = "grupo", ignore = true)
    Subgrupo toEntity(SubgrupoDTO subgrupoDTO);
}
