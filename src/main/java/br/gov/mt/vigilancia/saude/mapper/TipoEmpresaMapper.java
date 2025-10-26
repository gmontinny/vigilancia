package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.TipoEmpresa;
import br.gov.mt.vigilancia.saude.dto.TipoEmpresaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TipoEmpresaMapper {

    TipoEmpresaMapper INSTANCE = Mappers.getMapper(TipoEmpresaMapper.class);

    TipoEmpresaDTO toDto(TipoEmpresa tipoEmpresa);

    TipoEmpresa toEntity(TipoEmpresaDTO tipoEmpresaDTO);
}
