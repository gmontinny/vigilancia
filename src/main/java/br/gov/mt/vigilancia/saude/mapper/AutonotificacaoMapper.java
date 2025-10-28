package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Autonotificacao;
import br.gov.mt.vigilancia.saude.dto.AutonotificacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutonotificacaoMapper {

    AutonotificacaoMapper INSTANCE = Mappers.getMapper(AutonotificacaoMapper.class);

    @Mapping(source = "tramitacao.idtramitacao", target = "idtramitacao")
    AutonotificacaoDTO toDTO(Autonotificacao autonotificacao);

    @Mapping(source = "idtramitacao", target = "tramitacao.idtramitacao")
    Autonotificacao toEntity(AutonotificacaoDTO autonotificacaoDTO);
}
