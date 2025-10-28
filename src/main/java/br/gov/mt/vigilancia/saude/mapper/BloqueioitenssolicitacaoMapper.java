package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Bloqueioitenssolicitacao;
import br.gov.mt.vigilancia.saude.dto.BloqueioitenssolicitacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BloqueioitenssolicitacaoMapper {

    BloqueioitenssolicitacaoMapper INSTANCE = Mappers.getMapper(BloqueioitenssolicitacaoMapper.class);

    @Mapping(source = "itenssolicitacao.iditenssolicitacao", target = "iditenssolicitacao")
    BloqueioitenssolicitacaoDTO toDTO(Bloqueioitenssolicitacao bloqueioitenssolicitacao);

    @Mapping(source = "iditenssolicitacao", target = "itenssolicitacao.iditenssolicitacao")
    Bloqueioitenssolicitacao toEntity(BloqueioitenssolicitacaoDTO bloqueioitenssolicitacaoDTO);
}
