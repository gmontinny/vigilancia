package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Balancomedicamento;
import br.gov.mt.vigilancia.saude.dto.BalancomedicamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BalancomedicamentoMapper {

    BalancomedicamentoMapper INSTANCE = Mappers.getMapper(BalancomedicamentoMapper.class);

    @Mapping(source = "estabelecimento.id", target = "idestabelecimento")
    BalancomedicamentoDTO toDTO(Balancomedicamento balancomedicamento);

    @Mapping(source = "idestabelecimento", target = "estabelecimento.id")
    Balancomedicamento toEntity(BalancomedicamentoDTO balancomedicamentoDTO);
}
