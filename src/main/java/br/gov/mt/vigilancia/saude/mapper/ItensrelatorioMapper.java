package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensrelatorio;
import br.gov.mt.vigilancia.saude.dto.ItensrelatorioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensrelatorioMapper {

    ItensrelatorioMapper INSTANCE = Mappers.getMapper(ItensrelatorioMapper.class);

    @Mapping(source = "relatorio.idrelatorio", target = "idrelatorio")
    @Mapping(source = "usuario.id", target = "idusuario")
    ItensrelatorioDTO toDTO(Itensrelatorio itensrelatorio);

    @Mapping(source = "idrelatorio", target = "relatorio.idrelatorio")
    @Mapping(source = "idusuario", target = "usuario.id")
    Itensrelatorio toEntity(ItensrelatorioDTO itensrelatorioDTO);
}
