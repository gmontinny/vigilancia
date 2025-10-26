package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Tabela;
import br.gov.mt.vigilancia.saude.dto.TabelaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TabelaMapper {

    TabelaMapper INSTANCE = Mappers.getMapper(TabelaMapper.class);

    TabelaDTO toDto(Tabela tabela);

    Tabela toEntity(TabelaDTO tabelaDTO);
}
