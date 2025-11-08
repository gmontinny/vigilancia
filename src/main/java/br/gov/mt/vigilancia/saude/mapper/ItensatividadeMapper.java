package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensatividade;
import br.gov.mt.vigilancia.saude.dto.ItensatividadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensatividadeMapper {

    ItensatividadeMapper INSTANCE = Mappers.getMapper(ItensatividadeMapper.class);

    @Mapping(source = "atividades.idatividades", target = "idatividades")
    @Mapping(source = "estabelecimento.id", target = "idestabelecimento")
    ItensatividadeDTO toDTO(Itensatividade itensatividade);

    @Mapping(source = "idatividades", target = "atividades.idatividades")
    @Mapping(source = "idestabelecimento", target = "estabelecimento.id")
    Itensatividade toEntity(ItensatividadeDTO itensatividadeDTO);
}
