package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Agrupamento;
import br.gov.mt.vigilancia.saude.dto.AgrupamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgrupamentoMapper {

    AgrupamentoMapper INSTANCE = Mappers.getMapper(AgrupamentoMapper.class);

    AgrupamentoDTO toDTO(Agrupamento agrupamento);
    Agrupamento toEntity(AgrupamentoDTO agrupamentoDTO);
}
