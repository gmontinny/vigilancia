package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Categoriaproduto;
import br.gov.mt.vigilancia.saude.dto.CategoriaprodutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaprodutoMapper {

    CategoriaprodutoMapper INSTANCE = Mappers.getMapper(CategoriaprodutoMapper.class);

    CategoriaprodutoDTO toDTO(Categoriaproduto categoriaproduto);
    Categoriaproduto toEntity(CategoriaprodutoDTO categoriaprodutoDTO);
}
