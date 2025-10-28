package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Categoriaanalise;
import br.gov.mt.vigilancia.saude.dto.CategoriaanaliseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaanaliseMapper {

    CategoriaanaliseMapper INSTANCE = Mappers.getMapper(CategoriaanaliseMapper.class);

    CategoriaanaliseDTO toDTO(Categoriaanalise categoriaanalise);
    Categoriaanalise toEntity(CategoriaanaliseDTO categoriaanaliseDTO);
}
