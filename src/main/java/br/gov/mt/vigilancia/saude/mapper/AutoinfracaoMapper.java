package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Autoinfracao;
import br.gov.mt.vigilancia.saude.dto.AutoinfracaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutoinfracaoMapper {

    AutoinfracaoMapper INSTANCE = Mappers.getMapper(AutoinfracaoMapper.class);

    @Mapping(source = "tramitacao.idtramitacao", target = "idtramitacao")
    AutoinfracaoDTO toDTO(Autoinfracao autoinfracao);

    @Mapping(source = "idtramitacao", target = "tramitacao.idtramitacao")
    Autoinfracao toEntity(AutoinfracaoDTO autoinfracaoDTO);
}
