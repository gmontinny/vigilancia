package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Solicitacao;
import br.gov.mt.vigilancia.saude.dto.SolicitacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SolicitacaoMapper {

    SolicitacaoMapper INSTANCE = Mappers.getMapper(SolicitacaoMapper.class);

    SolicitacaoDTO toDTO(Solicitacao solicitacao);
    Solicitacao toEntity(SolicitacaoDTO solicitacaoDTO);
}
