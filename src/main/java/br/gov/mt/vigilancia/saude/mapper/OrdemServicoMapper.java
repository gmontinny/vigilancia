package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.OrdemServico;
import br.gov.mt.vigilancia.saude.dto.OrdemServicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ReclamacaoMapper.class})
public interface OrdemServicoMapper {

    OrdemServicoMapper INSTANCE = Mappers.getMapper(OrdemServicoMapper.class);

    @Mapping(source = "acao.id", target = "idacao")
    @Mapping(source = "processo.numeroProcesso", target = "numprocesso")
    @Mapping(target = "reclamacaos", source = "reclamacaos")
    OrdemServicoDTO toDTO(OrdemServico ordemservico);

    @Mapping(source = "idacao", target = "acao.id")
    @Mapping(source = "numprocesso", target = "processo.numeroProcesso")
    @Mapping(target = "reclamacaos", source = "reclamacaos")
    OrdemServico toEntity(OrdemServicoDTO ordemservicoDTO);
}
