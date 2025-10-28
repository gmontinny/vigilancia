package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itenssolicitacao;
import br.gov.mt.vigilancia.saude.dto.ItenssolicitacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItenssolicitacaoMapper {

    ItenssolicitacaoMapper INSTANCE = Mappers.getMapper(ItenssolicitacaoMapper.class);

    @Mapping(source = "solicitacao.idsolicitacao", target = "idsolicitacao")
    ItenssolicitacaoDTO toDTO(Itenssolicitacao itenssolicitacao);

    @Mapping(source = "idsolicitacao", target = "solicitacao.idsolicitacao")
    Itenssolicitacao toEntity(ItenssolicitacaoDTO itenssolicitacaoDTO);
}
