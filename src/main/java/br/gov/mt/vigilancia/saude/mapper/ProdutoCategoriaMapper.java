package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.ProdutoCategoria;
import br.gov.mt.vigilancia.saude.dto.ProdutoCategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoCategoriaMapper {

    ProdutoCategoriaMapper INSTANCE = Mappers.getMapper(ProdutoCategoriaMapper.class);

    ProdutoCategoriaDTO toDTO(ProdutoCategoria produtocategoria);

    @Mapping(target = "reclamacaos", ignore = true)
    ProdutoCategoria toEntity(ProdutoCategoriaDTO produtocategoriaDTO);
}
