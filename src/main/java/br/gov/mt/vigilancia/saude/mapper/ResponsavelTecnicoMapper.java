package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.ResponsavelTecnico;
import br.gov.mt.vigilancia.saude.dto.ResponsavelTecnicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResponsavelTecnicoMapper {

    ResponsavelTecnicoMapper INSTANCE = Mappers.getMapper(ResponsavelTecnicoMapper.class);

    @Mapping(source = "conselho.id", target = "idConselho")
    ResponsavelTecnicoDTO toDto(ResponsavelTecnico responsavelTecnico);

    @Mapping(target = "conselho", ignore = true)
    ResponsavelTecnico toEntity(ResponsavelTecnicoDTO responsavelTecnicoDTO);
}
