package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.ProdutoCategoria;
import br.gov.mt.vigilancia.saude.dto.ProdutoCategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoCategoriaMapper {

    ProdutoCategoriaMapper INSTANCE = Mappers.getMapper(ProdutoCategoriaMapper.class);

    ProdutoCategoriaDTO toDto(ProdutoCategoria produtoCategoria);

    ProdutoCategoria toEntity(ProdutoCategoriaDTO produtoCategoriaDTO);
}
