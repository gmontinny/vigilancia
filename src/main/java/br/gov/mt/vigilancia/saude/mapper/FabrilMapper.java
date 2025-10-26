package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Fabril;
import br.gov.mt.vigilancia.saude.dto.FabrilDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FabrilMapper {

    FabrilMapper INSTANCE = Mappers.getMapper(FabrilMapper.class);

    FabrilDTO toDto(Fabril fabril);

    Fabril toEntity(FabrilDTO fabrilDTO);
}
