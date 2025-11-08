package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensavaliacao;
import br.gov.mt.vigilancia.saude.dto.ItensavaliacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensavaliacaoMapper {

    ItensavaliacaoMapper INSTANCE = Mappers.getMapper(ItensavaliacaoMapper.class);

    @Mapping(source = "gestaodocumento.idgestaodocumento", target = "idgestaodocumento")
    ItensavaliacaoDTO toDTO(Itensavaliacao itensavaliacao);

    @Mapping(source = "idgestaodocumento", target = "gestaodocumento.idgestaodocumento")
    Itensavaliacao toEntity(ItensavaliacaoDTO itensavaliacaoDTO);
}
