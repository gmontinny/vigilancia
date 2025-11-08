package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Tramitacao;
import br.gov.mt.vigilancia.saude.dto.TramitacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TramitacaoMapper {

    TramitacaoMapper INSTANCE = Mappers.getMapper(TramitacaoMapper.class);

    @Mapping(source = "ordemservico.idordemservico", target = "idordemservico")
    @Mapping(source = "tipoinspecao.idtipoinspecao", target = "idtipoinspecao")
    TramitacaoDTO toDTO(Tramitacao tramitacao);

    @Mapping(source = "idordemservico", target = "ordemservico.idordemservico")
    @Mapping(source = "idtipoinspecao", target = "tipoinspecao.idtipoinspecao")
    Tramitacao toEntity(TramitacaoDTO tramitacaoDTO);
}
