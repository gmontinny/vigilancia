package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Empresainfracoe;
import br.gov.mt.vigilancia.saude.dto.EmpresainfracoeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpresainfracoeMapper {

    EmpresainfracoeMapper INSTANCE = Mappers.getMapper(EmpresainfracoeMapper.class);

    EmpresainfracoeDTO toDTO(Empresainfracoe empresainfracoe);
    Empresainfracoe toEntity(EmpresainfracoeDTO empresainfracoeDTO);
}
