package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geraatividade;
import br.gov.mt.vigilancia.saude.dto.GeraatividadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeraatividadeMapper {

    GeraatividadeMapper INSTANCE = Mappers.getMapper(GeraatividadeMapper.class);

    GeraatividadeDTO toDTO(Geraatividade geraatividade);
    Geraatividade toEntity(GeraatividadeDTO geraatividadeDTO);
}
