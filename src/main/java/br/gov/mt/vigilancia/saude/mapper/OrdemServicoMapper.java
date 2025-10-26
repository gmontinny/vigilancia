package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.OrdemServico;
import br.gov.mt.vigilancia.saude.dto.OrdemServicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AcaoMapper.class, ProcessoMapper.class})
public interface OrdemServicoMapper {

    OrdemServicoMapper INSTANCE = Mappers.getMapper(OrdemServicoMapper.class);

    @Mapping(source = "acao.id", target = "idAcao")
    @Mapping(source = "processo.numeroProcesso", target = "numeroProcesso")
    OrdemServicoDTO toDto(OrdemServico ordemServico);

    @Mapping(target = "acao", ignore = true)
    @Mapping(target = "processo", ignore = true)
    OrdemServico toEntity(OrdemServicoDTO ordemServicoDTO);
}
