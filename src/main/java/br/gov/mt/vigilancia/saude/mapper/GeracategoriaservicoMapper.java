package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geracategoriaservico;
import br.gov.mt.vigilancia.saude.dto.GeracategoriaservicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeracategoriaservicoMapper {

    GeracategoriaservicoMapper INSTANCE = Mappers.getMapper(GeracategoriaservicoMapper.class);

    GeracategoriaservicoDTO toDTO(Geracategoriaservico geracategoriaservico);
    Geracategoriaservico toEntity(GeracategoriaservicoDTO geracategoriaservicoDTO);
}
