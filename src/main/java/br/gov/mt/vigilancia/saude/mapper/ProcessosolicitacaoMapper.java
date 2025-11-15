package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Processosolicitacao;
import br.gov.mt.vigilancia.saude.dto.ProcessosolicitacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProcessosolicitacaoMapper {

    ProcessosolicitacaoMapper INSTANCE = Mappers.getMapper(ProcessosolicitacaoMapper.class);

    @Mapping(source = "itenssolicitacao.iditenssolicitacao", target = "iditenssolicitacao")
    ProcessosolicitacaoDTO toDTO(Processosolicitacao processosolicitacao);

    @Mapping(source = "iditenssolicitacao", target = "itenssolicitacao.iditenssolicitacao")
    Processosolicitacao toEntity(ProcessosolicitacaoDTO processosolicitacaoDTO);
}
