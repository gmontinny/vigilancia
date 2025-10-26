package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Categoria;
import br.gov.mt.vigilancia.saude.dto.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO toDto(Categoria categoria);

    Categoria toEntity(CategoriaDTO categoriaDTO);
}
