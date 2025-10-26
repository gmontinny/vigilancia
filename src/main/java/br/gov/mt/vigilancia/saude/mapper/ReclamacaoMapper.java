package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Reclamacao;
import br.gov.mt.vigilancia.saude.dto.ReclamacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OrdemServicoMapper.class, ProdutoCategoriaMapper.class})
public interface ReclamacaoMapper {

    ReclamacaoMapper INSTANCE = Mappers.getMapper(ReclamacaoMapper.class);

    @Mapping(source = "ordemServico.id", target = "idOrdemServico")
    @Mapping(source = "produtoCategoria.id", target = "idProdutoCategoria")
    ReclamacaoDTO toDto(Reclamacao reclamacao);

    @Mapping(target = "ordemServico", ignore = true)
    @Mapping(target = "produtoCategoria", ignore = true)
    Reclamacao toEntity(ReclamacaoDTO reclamacaoDTO);
}
