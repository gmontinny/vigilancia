package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensautoinfracao;
import br.gov.mt.vigilancia.saude.dto.ItensautoinfracaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensautoinfracaoMapper {

    ItensautoinfracaoMapper INSTANCE = Mappers.getMapper(ItensautoinfracaoMapper.class);

    ItensautoinfracaoDTO toDTO(Itensautoinfracao itensautoinfracao);
    Itensautoinfracao toEntity(ItensautoinfracaoDTO itensautoinfracaoDTO);
}
