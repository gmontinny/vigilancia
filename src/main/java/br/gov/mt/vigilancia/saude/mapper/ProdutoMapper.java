package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Produto;
import br.gov.mt.vigilancia.saude.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProcessoMapper.class})
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(source = "processo.numeroProcesso", target = "numeroProcesso")
    ProdutoDTO toDto(Produto produto);

    @Mapping(target = "processo", ignore = true)
    Produto toEntity(ProdutoDTO produtoDTO);
}
