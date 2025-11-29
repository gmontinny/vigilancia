package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Tabelainfracoe;
import br.gov.mt.vigilancia.saude.dto.TabelainfracoeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TabelainfracoeMapper {

    TabelainfracoeMapper INSTANCE = Mappers.getMapper(TabelainfracoeMapper.class);

    TabelainfracoeDTO toDTO(Tabelainfracoe tabelainfracoe);
    Tabelainfracoe toEntity(TabelainfracoeDTO tabelainfracoeDTO);
}
