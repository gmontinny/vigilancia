package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Assuntosolicitacao;
import br.gov.mt.vigilancia.saude.dto.AssuntosolicitacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AssuntosolicitacaoMapper {

    AssuntosolicitacaoMapper INSTANCE = Mappers.getMapper(AssuntosolicitacaoMapper.class);

    AssuntosolicitacaoDTO toDTO(Assuntosolicitacao assuntosolicitacao);
    Assuntosolicitacao toEntity(AssuntosolicitacaoDTO assuntosolicitacaoDTO);
}
