package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensroteiro;
import br.gov.mt.vigilancia.saude.dto.ItensroteiroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensroteiroMapper {

    ItensroteiroMapper INSTANCE = Mappers.getMapper(ItensroteiroMapper.class);

    @Mapping(source = "categoriaroteiro.idcategoriaroteiro", target = "idcategoriaroteiro")
    @Mapping(source = "legislacao.idlegislacao", target = "idlegislacao")
    ItensroteiroDTO toDTO(Itensroteiro itensroteiro);

    @Mapping(source = "idcategoriaroteiro", target = "categoriaroteiro.idcategoriaroteiro")
    @Mapping(source = "idlegislacao", target = "legislacao.idlegislacao")
    Itensroteiro toEntity(ItensroteiroDTO itensroteiroDTO);
}
