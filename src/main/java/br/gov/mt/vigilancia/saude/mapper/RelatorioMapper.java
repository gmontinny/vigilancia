package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Relatorio;
import br.gov.mt.vigilancia.saude.dto.RelatorioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ItensrelatorioMapper.class})
public interface RelatorioMapper {

    RelatorioMapper INSTANCE = Mappers.getMapper(RelatorioMapper.class);

    @Mapping(target = "itensrelatorios", source = "itensrelatorios")
    RelatorioDTO toDTO(Relatorio relatorio);

    @Mapping(target = "itensrelatorios", source = "itensrelatorios")
    Relatorio toEntity(RelatorioDTO relatorioDTO);
}
