package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensexiberoteiro;
import br.gov.mt.vigilancia.saude.dto.ItensexiberoteiroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensexiberoteiroMapper {

    ItensexiberoteiroMapper INSTANCE = Mappers.getMapper(ItensexiberoteiroMapper.class);

    @Mapping(source = "exiberoteiro.idexiberoteiro", target = "idexiberoteiro")
    @Mapping(source = "itensroteiro.iditensroteiro", target = "iditensroteiro")
    ItensexiberoteiroDTO toDTO(Itensexiberoteiro itensexiberoteiro);

    @Mapping(source = "idexiberoteiro", target = "exiberoteiro.idexiberoteiro")
    @Mapping(source = "iditensroteiro", target = "itensroteiro.iditensroteiro")
    Itensexiberoteiro toEntity(ItensexiberoteiroDTO itensexiberoteiroDTO);
}
