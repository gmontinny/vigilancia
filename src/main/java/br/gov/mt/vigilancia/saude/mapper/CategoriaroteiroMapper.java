package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Categoriaroteiro;
import br.gov.mt.vigilancia.saude.dto.CategoriaroteiroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaroteiroMapper {

    CategoriaroteiroMapper INSTANCE = Mappers.getMapper(CategoriaroteiroMapper.class);

    CategoriaroteiroDTO toDTO(Categoriaroteiro categoriaroteiro);
    Categoriaroteiro toEntity(CategoriaroteiroDTO categoriaroteiroDTO);
}
