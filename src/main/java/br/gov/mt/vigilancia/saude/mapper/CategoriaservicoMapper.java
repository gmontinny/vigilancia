package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Categoriaservico;
import br.gov.mt.vigilancia.saude.dto.CategoriaservicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaservicoMapper {

    CategoriaservicoMapper INSTANCE = Mappers.getMapper(CategoriaservicoMapper.class);

    CategoriaservicoDTO toDTO(Categoriaservico categoriaservico);
    Categoriaservico toEntity(CategoriaservicoDTO categoriaservicoDTO);
}
